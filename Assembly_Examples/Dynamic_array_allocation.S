# ====================================================
# Basic Array Allocation Example
# 
# This just shows a simple way to allocate space for an array.
#
# The program reads in an array of N values and a second array of 
# M values and then prints out the Cartesian product:
#    (a1,b1), (a1,b2), (a1,b3), ..., (a2, b1), (a2, b2), ...
#
# N.B.:
# This uses the environment call sbrk (9) to allocate heap space 
# of a given size. It works by just increasing the available memory.
# There is no process to free space (though the end of space can be removed).
# For our purposes, that is fine. We'll have huge memory leaks but garbage
# collection and memory management are big topics for their own class really!
# 
# Author: Christian Duncan
# ====================================================
    .data
msg1: .asciz "How many elements are in the first array?\n"
msg2: .asciz "Please enter the elements.\n"
msg3: .asciz "How many elements are in the second array?\n"
msg4: .asciz "The Cartesian product of the two arrays is:\n"
A: .word 0  # Will store location of Array A
B: .word 0  # ... Array B
n: .word 0  # Size of Array A
m: .word 0  # ... Array B
i: .word 0  # Index into one array
j: .word 0  # Index into other array

    .text

main:
    # ==========================
    # Read in Array A
    # ==========================
    # Get value of N
    la  a0, msg1
    li  a7, 4   # PrintString
    ecall

    li a7, 5    # Read integer
    ecall
    la  t0, n
    sw  a0, (t0)

    # Allocate an array of size N
    la t0, n
    lw a0, (t0)  # Not really needed since a0 already contains this value!
    slli a0, a0, 2 # Effectively multiply by 2^2=4 (Space is 4*N)
    li a7, 9     # SBRK = 9
    ecall
    la t0, A
    sw a0, (t0)  # Store memory location in A

    # Read in the N values
    la t0, i
    li t1, 0
    sw t1, (t0)  # Store i=0

    la  a0, msg2
    li  a7, 4   # PrintString
    ecall
loop1:
    la t0, i
    lw t0, (t0) # t0 = i
    la t1, n
    lw t1, (t1) # t1 = n

    bge t0, t1, loop1_end  # If i >= n, go to loop1_end

    # Read in one number
    li  a7, 5 # ReadInteger
    ecall

    # Store a0 in location A[i]: A[i] = a0
    # First compute memory location of A[i]
    #   This is done by computing A+4*i  (since using array of integers)
    la t0, A
    lw t0, (t0)  # t0 has memory address for A
    la t1, i
    lw t1, (t1)  # t1 has value i
    slli t1, t1, 2  # multiply by 4 because each integer is 4 bytes
    add t0, t0, t1  # location t0 = A + (4*i)
    sw a0, (t0)     # A[i] = a0

    # Increment i (i = i + 1) and loop
    la t0, i
    lw t1, (t0)
    addi t1, t1, 1
    sw t1, (t0)
    
    j loop1

loop1_end:

    # ==========================
    # Read in Array B
    # ==========================
    # Get value of M
    la  a0, msg3
    li  a7, 4   # PrintString
    ecall

    li a7, 5    # Read integer
    ecall
    la  t0, m
    sw  a0, (t0)

    # Allocate an array of size M
    la t0, m
    lw a0, (t0)  # Not really needed since a0 already contains this value!
    slli a0, a0, 2 # Effectively multiply by 2^2=4 (Space is 4*N)
    li a7, 9     # SBRK = 9
    ecall
    la t0, B
    sw a0, (t0)  # Store memory location in B

    # Read in the M values
    la t0, i
    li t1, 0
    sw t1, (t0)  # Store i=0

    la  a0, msg2
    li  a7, 4   # PrintString
    ecall
loop2:
    la t0, i
    lw t0, (t0) # t0 = i
    la t1, m
    lw t1, (t1) # t1 = m

    bge t0, t1, loop2_end  # If i >= m, go to loop1_end

    # Read in one number
    li  a7, 5 # ReadInteger
    ecall

    # Store a0 in location B[i]: B[i] = a0
    # First compute memory location of B[i]
    #   This is done by computing B+4*i  (since using array of integers)
    la t0, B
    lw t0, (t0)  # t0 has memory address for B
    la t1, i
    lw t1, (t1)  # t1 has value i
    slli t1, t1, 2  # multiply by 4 because each integer is 4 bytes
    add t0, t0, t1  # location t0 = B + (4*i)
    sw a0, (t0)     # B[i] = a0

    # Increment i (i = i + 1) and loop
    la t0, i
    lw t1, (t0)
    addi t1, t1, 1
    sw t1, (t0)
    
    j loop2

loop2_end:

    # ==========================
    # Print out Cartesian Product
    # ==========================
    la  a0, msg4
    li  a7, 4   # PrintString
    ecall

    # Set i to 0
    la t0, i
    li t1, 0
    sw t1, (t0)

loop3:
    # Is i >= n? If so, exit loop
    la t0, i
    lw t0, (t0) # t0 = i
    la t1, n
    lw t1, (t1) # t1 = n
    bge t0, t1, loop3_end

    # Set j to 0
    la t0, j
    li t1, 0
    sw t1, (t0)

loop4:
    # Is j >= m? If so, exit loop
    la t0, j
    lw t0, (t0) # t0 = j
    la t1, m
    lw t1, (t1) # t1 = m
    bge t0, t1, loop4_end

    # Print out (A[i], B[j])
    li a0, '('
    li a7, 11
    ecall
    
    ### Get value of A[i]
    la t0, A
    lw t0, (t0)  # t0 has memory address for A
    la t1, i
    lw t1, (t1)  # t1 has value i
    slli t1, t1, 2  # multiply by 4 because each integer is 4 bytes
    add t0, t0, t1  # location t0 = A + (4*i)
    lw a0, (t0)     # a0 = A[i]
    li a7, 1
    ecall

    li a0, ','
    li a7, 11
    ecall

    ### Get value of B[j]
    la t0, B
    lw t0, (t0)  # t0 has memory address for B
    la t1, j
    lw t1, (t1)  # t1 has value j
    slli t1, t1, 2  # multiply by 4 because each integer is 4 bytes
    add t0, t0, t1  # location t0 = B + (4*j)
    lw a0, (t0)     # a0 = B[j]
    li a7, 1
    ecall

    li a0, ')'
    li a7, 11
    ecall

    # j = j + 1
    la t0, j
    lw t1, (t0)
    addi t1, t1, 1
    sw t1, (t0)

    j loop4
loop4_end:
    # Print newline
    li a0, '\n'
    li a7, 11
    ecall

    # i = i + 1
    la t0, i
    lw t1, (t0)
    addi t1, t1, 1
    sw t1, (t0)

    j loop3

loop3_end:

    # ==========================
    # End of program
    # ==========================
    li    a0, 0     # Load the exit code (e.g., 0 for success) into a0
    li    a7, 93    # Load the Exit2 syscall number into a7
    ecall        # Execute the system call to exit


# EXAMPLE RUN
# How many elements are in the first array?
# 4
# Please enter the elements.
# 1
# 2
# 3
# 4
# How many elements are in the second array?
# 2
# Please enter the elements.
# 5
# 6
# The Cartesian product of the two arrays is:
# (1,5)(1,6)
# (2,5)(2,6)
# (3,5)(3,6)
# (4,5)(4,6)