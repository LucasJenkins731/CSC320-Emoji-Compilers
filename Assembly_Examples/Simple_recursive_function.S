# ====================================================
# Simple Recursive Function Example
# 
# Just showing how to use the stack to perform recursion.
# We will read in a number N and then recursively count
# down from N to 1.
#
# Author: Christian Duncan
# ====================================================
    .data
msg1: .asciz "What is the value of N?\n"
msg2: .asciz "Counting down...\n"
msg3: .asciz "Done. Good-bye!\n"
n: .word 0

    .text

main:
    # Get value of N
    la  a0, msg1
    li  a7, 4   # PrintString
    ecall

    li a7, 5    # Read integer
    ecall
    la  t0, n
    sw  a0, (t0)

    la  a0, msg2
    li  a7, 4   # PrintString
    ecall

    # Call f(n)
    # Prologue - things to do BEFORE invoking the function
    # Push the value of n onto the stack
    la  t0, n
    lw  a0, (t0)
    addi sp, sp, -4
    sw a0, 0(sp)

    # Make the function call
    jal f
    
    # Epilogue - things to do AFTER returning from the function
    addi sp, sp, 4  # Pop off the argument n

    la    a0, msg3
    li    a7, 4    # PrintString
    ecall

    j end

end:
    li    a0, 0     # Load the exit code (e.g., 0 for success) into a0
    li    a7, 93    # Load the Exit2 syscall number into a7
    ecall        # Execute the system call to exit

# An example of a simple subroutine
print_newline:
    li    a0, '\n'
    li    a7, 11
    ecall
    ret

# f(n) - recursively prints down from N to 1
f:
    # ====================================================
    # Prologue (things to do BEFORE starting the function)
    # Save the return address onto the stack
    addi sp, sp, -4
    sw ra, 0(sp)
    # ====================================================

    # ====================================================
    # The main body
    # ====================================================
    # Get value of n.
    lw a0, 4(sp)

    # Base case (are we done yet?) if n <= 0 goto to end of fx
    blez a0, f_epi

    # Print n (in a0)
    li a7, 1
    ecall
    jal print_newline

    # Call f(n-1)
    # Prologue - things to do BEFORE invoking the function
    # Push the value of n-1 onto the stack
    lw a0, 4(sp)
    addi a0, a0, -1
    addi sp, sp, -4
    sw a0, 0(sp)

    # Make the function call
    jal f

    # Epilogue - things to do AFTER returning from the function
    addi sp, sp, 4  # Pop off the argument

    # End call f(n-1)

f_epi:
    # ====================================================
    # Epilogue (things to do BEFORE leaving the function)
    # ====================================================
    lw ra, 0(sp)
    addi sp, sp, 4

    ret