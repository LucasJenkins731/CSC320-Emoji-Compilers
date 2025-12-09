

# Stack allocation for variables when we have functions working.



main:

    # This is what the prologue should look like when we are creating a function
    addi $sp, $sp, -32     # allocate 32 bytes
    sw   $ra, 28($sp)      # save return address
    sw   $fp, 24($sp)      # save frame pointer
    addi $fp, $sp, 32      # new frame pointer

    # int a = 5;
    li   $t0, 5
    sw   $t0, -4($fp)

    # int b = 10;
    li   $t1, 10
    sw   $t1, -8($fp)

    # int c = a + b;
    lw   $t2, -4($fp)
    lw   $t3, -8($fp)
    add  $t4, $t2, $t3
    sw   $t4, -12($fp)


    # This is what the epilogue should look like.
    # exit main
    lw   $ra, 28($sp)
    lw   $fp, 24($sp)
    addi $sp, $sp, 32
    jr   $ra
