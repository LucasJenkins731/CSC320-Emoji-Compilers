# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 3.0
VAL1:    .double 0.0
VAL2:    .double 1.0
STR3:    .asciz "Testing nested loops for 3x3 iteration"
STR4:    .asciz "Outer loop i ="
STR5:    .asciz "  Inner loop j ="
STR6:    .asciz "Nested loops completed"
IDXzero:    .double 0.0
IDXone:    .double 0.0
IDXi:    .double 0.0
IDXj:    .double 0.0
IDXn:    .double 0.0
    .text
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXn
    fsd fa0,(t0)
    la t0,VAL1
    fld fa0,(t0)
    la t0,IDXzero
    fsd fa0,(t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXone
    fsd fa0,(t0)
    la    a0, STR3
    li    a7, 4
    ecall
    la t0,IDXzero
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_2:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_3
    la    a0, STR4
    li    a7, 4
    ecall
    la t0,IDXi
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXzero
    fld fa0,(t0)
    la t0,IDXj
    fsd fa0,(t0)
LOOP_0:
    la t0,IDXj
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_1
    la    a0, STR5
    li    a7, 4
    ecall
    la t0,IDXj
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXj
    fld fa0,(t0)
    la t0,IDXone
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXj
    fsd fa0,(t0)
    j LOOP_0
END_LOOP_1:
    la t0,IDXi
    fld fa0,(t0)
    la t0,IDXone
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_2
END_LOOP_3:
    la    a0, STR6
    li    a7, 4
    ecall
end:
    li    a0, 0
    li    a7, 93
    ecall
