# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
STR0:    .asciz "income: "
STR1:    .asciz "rent: "
STR2:    .asciz "food: "
STR3:    .asciz "fun: "
STR4:    .asciz "total ="
STR5:    .asciz "savings ="
IDXincome:    .double 0.0
IDXtotal:    .double 0.0
IDXsavings:    .double 0.0
IDXrent:    .double 0.0
IDXfood:    .double 0.0
IDXfun:    .double 0.0
    .text
    .globl main
main: 
    la    a0, STR0
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXincome
    fsd fa0,(t0)
    la    a0, STR1
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXrent
    fsd fa0,(t0)
    la    a0, STR2
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXfood
    fsd fa0,(t0)
    la    a0, STR3
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXfun
    fsd fa0,(t0)
    la t0,IDXrent
    fld fa0,(t0)
    la t0,IDXfood
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXfun
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,IDXincome
    fld fa0,(t0)
    la t0,IDXtotal
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    la t0,IDXsavings
    fsd fa0,(t0)
    la    a0, STR4
    li    a7, 4
    ecall
    la t0,IDXtotal
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR5
    li    a7, 4
    ecall
    la t0,IDXsavings
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
end:
    li    a0, 0
    li    a7, 93
    ecall
