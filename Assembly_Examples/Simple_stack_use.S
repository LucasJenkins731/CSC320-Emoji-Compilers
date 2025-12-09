# ====================================================
# Simple Stack Example
# 
# Just a simple example to show the use of the stack.
# Reads in N numbers. Pushes them all onto the stack.
# Then pops them off and adds them up, printing the
# sum at the end.
#
# NOTE: This uses 64-bit values so to have an instruction like fmv.d.x
#       I need to run: java -jar rars.jar simpleStack.s rv64
#       If using the IDE, select 64-bit under settings.
#
# Author: Christian Duncan
# ====================================================
    .data
msg1: .asciz "How many floating point numbers do you wish to enter?\n"
msg2: .asciz "Please enter each floating point number.\n"
n: .word 0

    .text

main:
    # How many values are we reading in?
    la  a0, msg1
    li  a7, 4   # PrintString
    ecall

    li a7, 5    # Read integer
    ecall
    la  t0, n
    sw  a0, (t0)

    # Read in all N values
    addi t1, a0, 0   # t1 will be a count of how many more we have left

    la  a0, msg2
    li  a7, 4   # PrintString
    ecall
loop1:
    blez t1, loop1_end  # If t1 <= 0, go to loop1_end
    addi t1, t1, -1

    # Read in one number
    li  a7, 7 # ReadDouble
    ecall

    # Push the value onto the stack
    addi sp, sp, -8   # A double is 64-bit (8-bytes) so move stack down that much
    fsd fa0, 0(sp)
    
    j loop1

loop1_end:

    # Now pop them all off and add them up
    la t1, n
    lw t1, (t1)  # t1 = N
    fmv.d.x fa0, zero  # Set fa0 to 0.0   - this will store the sum
loop2:
    blez t1, loop2_end # If t1 <= 0, go to loop2_end
    addi t1, t1, -1
    
    # Pop one (double) number off stack and add it to fa0
    fld fa1, 0(sp)  # Get double value at the top of stack
    addi sp, sp, 8  # Pop it off
    fadd.d fa0, fa0, fa1   # sum = sum + new_value
    
    j loop2
loop2_end:
    # Print out the sum (already in fa0!)
    li a7, 3
    ecall
    jal print_newline
            
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