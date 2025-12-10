# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 2.0
VAL1:    .double 3.0
VAL2:    .double 4.0
VAL3:    .double 2.0
VAL4:    .double 3.0
VAL5:    .double 4.0
STR6:    .asciz "Without parens:"
STR7:    .asciz "With parens:"
IDXx:    .double 0.0
IDXy:    .double 0.0
    .text
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,VAL1
    fld ft0,(t0)
    la t0,VAL2
    fld ft1,(t0)
    fmul.d ft0,ft0,ft1
    fadd.d fa0,fa0,ft0
    la t0,IDXx
    fsd fa0,(t0)
    la t0,VAL3
    fld fa0,(t0)
    la t0,VAL4
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,VAL5
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXy
    fsd fa0,(t0)
    la    a0, STR6
    li    a7, 4
    ecall
    la t0,IDXx
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR7
    li    a7, 4
    ecall
    la t0,IDXy
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
