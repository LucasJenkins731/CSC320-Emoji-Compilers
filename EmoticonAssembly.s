# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 3.0
VAL1:    .double 1.0
VAL2:    .double 2.0
VAL3:    .double 3.0
STR4:    .asciz "Manual calculation check:"
STR5:    .asciz "3 is odd: 3*3+1 should be 10"
STR6:    .asciz "Result:"
IDXresult:    .double 0.0
IDXtemp:    .double 0.0
IDXone:    .double 0.0
IDXtwo:    .double 0.0
IDXnum_three:    .double 0.0
IDXn:    .double 0.0
    .text
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXn
    fsd fa0,(t0)
    la t0,VAL1
    fld fa0,(t0)
    la t0,IDXone
    fsd fa0,(t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXtwo
    fsd fa0,(t0)
    la t0,VAL3
    fld fa0,(t0)
    la t0,IDXnum_three
    fsd fa0,(t0)
    la    a0, STR4
    li    a7, 4
    ecall
    la    a0, STR5
    li    a7, 4
    ecall
    la t0,IDXnum_three
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    la t0,IDXone
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXresult
    fsd fa0,(t0)
    la    a0, STR6
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
