# ====================================================
# Average of absolute values
# 
# This program reads in a list of N numbers and prints the 
# average of the absolute value of those N numbers.
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

N: .word 0       # The number of items
sum: .double 0.0 # Sum of all the numbers

    .text
    .globl main
    .globl end
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

loop1:
    # while (a1 < N) { ... }
    la      t1, N
    lw      a0, 0(t1) 
    bge     a1, a0, endLoop1

    li      a7, eReadDouble    # Stores the number in fa0
    ecall
    fabs.d fa0, fa0            # COmpute the absolute value of the number

    # Compute sum = sum + fa0
    la      t1, sum
    fld     fa1, 0(t1)
    fadd.d  fa1, fa1, fa0
    fsd     fa1, 0(t1)

    # One more done, and... repeat
    addi    a1, a1, 1
    j loop1

endLoop1:
    # Compute and print the average
    la      t1, sum
    fld     fa0, 0(t1)

    la      t1, N
    lw      a1, 0(t1)
    fcvt.d.w fa1, a1

    fdiv.d  fa0, fa0, fa1
    li      a7, ePrintDouble
    ecall
    jal print_newline

    # End program
    j end

# An example of a simple subroutine
print_newline:
    li    a0, '\n'
    li    a7, 11
    ecall
    ret

end:
    li    a0, 0     # Load the exit code (e.g., 0 for success) into a0
    li    a7, 93    # Load the Exit2 syscall number into a7
    ecall        # Execute the system call to exit
    