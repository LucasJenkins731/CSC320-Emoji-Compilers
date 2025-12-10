# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 10.0
VAL1:    .double 5.0
VAL2:    .double 2.0
STR3:    .asciz "x ="
STR4:    .asciz "y ="
STR5:    .asciz "result ="
IDXresult:    .double 0.0
IDXx:    .double 0.0
IDXy:    .double 0.0
    .text
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXx
    fsd fa0,(t0)
    la t0,IDXx
    fld fa0,(t0)
    la t0,VAL1
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXy
    fsd fa0,(t0)
    la t0,IDXy
    fld fa0,(t0)
    la t0,VAL2
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXx
    fsd fa0,(t0)
    la t0,IDXx
    fld fa0,(t0)
    la t0,IDXy
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    la t0,IDXresult
    fsd fa0,(t0)
    la    a0, STR3
    li    a7, 4
    ecall
    la t0,IDXx
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR4
    li    a7, 4
    ecall
    la t0,IDXy
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR5
    li    a7, 4
    ecall
    la t0,IDXresult
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
