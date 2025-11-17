    .data
msg:    .asciiz "Hello, World!\n"

    .text
    .globl main

main:
    li   a7, 4     # RARS: PrintString service number
    la   a0, msg   # argument: address of null-terminated string
    ecall          # invoke simulator service to print the string

    li   a7, 10    # RARS: Exit service number
    ecall          # terminate program
