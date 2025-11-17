# ====================================================
# List in reverse
# 
# This program reads in a list of N numbers and prints the 
# numbers in reverse order.
#
# Author: Christian Duncan
# ====================================================
# Some assembler constants for easier reading
    .eqv ePrintInt, 1
    .eqv ePrintFloat, 2
    .eqv ePrintDouble, 3
    .eqv ePrintString, 4
    .eqv eReadInt, 5
    .eqv eReadFloat, 6
    .eqv eReadDouble, 7
    .eqv eReadString, 8

    .data
prompt1: .asciz "How many numbers will there be?\n"
prompt2: .asciz "Please enter the "
prompt3: .asciz " numbers.\n"
prompt4: .asciz "Here are the numbers in reverse order.\n"

.align 3         # Start the array at a double
arr: .space 50   # 50 bytes to store the items (PROBLEM!!!!)
N: .word 0       # The number of items

    .text
    .globl main
    .globl end
    .globl print_space
    .globl print_newline

main:
    # How many numbers will there be?
    la      a0, prompt1
    li      a7, ePrintString
    ecall

    li      a7, eReadInt
    ecall
    la      t1, N
    sw      a0, 0(t1)

    # Print out "Please enter the N numbers"
    la      a0, prompt2
    li      a7, ePrintString
    ecall

    la      t1, N
    lw      a0, 0(t1) 
    li      a7, ePrintInt
    ecall

    la      a0, prompt3
    li      a7, ePrintString
    ecall

    # Now read in the N values
    li      a1, 0    # How many numbers we have read so far
    la      a2, arr  # Start of our data array

loop1:
    # while (a1 < N) { ... }
    la      t1, N
    lw      a0, 0(t1) 
    bge     a1, a0, endLoop1

    li      a7, ePrintInt
    ecall
    jal print_newline

    li      a7, eReadDouble    # Stores the number in fa0
    ecall
    fsd     fa0, 0(a2)         # Store result in location at address a2

    # One more done, and... repeat
    addi    a1, a1, 1
    addi    a2, a2, 8    # Why 8?
    j loop1

endLoop1:
    # Print out "Here are the numbers in reverse order."
    la      a0, prompt4
    li      a7, ePrintString
    ecall

    # Loop and print the numbers (in reverse order)
    # a1 - count on N (count down)
    # a2 - address in array (count down)
loop2:
    addi    a1, a1, -1
    addi    a2, a2, -8    # Why -8?
    bltz    a1, endLoop2 # endLoop if a1 < 0

    # Display values of a1 and a2
    addi    a0, a1, 0
    li      a7, ePrintInt
    ecall
    jal print_space
    addi    a0, a2, 0
    li      a7, ePrintInt
    ecall
    jal print_space

    fld     fa0, (a2)   # Get value in current array location
    li      a7, ePrintDouble # Print out value in fa0
    ecall
    jal print_newline

    j loop2

endLoop2:
    # End program
    j end

# An example of a simple subroutine
print_space:
    li    a0, ' '
    li    a7, 11
    ecall
    ret

print_newline:
    li    a0, '\n'
    li    a7, 11
    ecall
    ret

end:
    li    a0, 0     # Load the exit code (e.g., 0 for success) into a0
    li    a7, 93    # Load the Exit2 syscall number into a7
    ecall        # Execute the system call to exit
    