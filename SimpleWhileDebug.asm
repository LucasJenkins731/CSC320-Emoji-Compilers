# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 3.0
VAL1:    .double 0.0
VAL2:    .double 1.0
STR3:    .asciz "Before loop, counter ="
STR4:    .asciz "In loop, counter ="
STR5:    .asciz "After decrement, counter ="
STR6:    .asciz "After loop, final counter ="
IDXzero:    .double 0.0
IDXone:    .double 0.0
IDXcounter:    .double 0.0
    .text
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXcounter
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
    la t0,IDXcounter
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
LOOP_0:
    la t0,IDXcounter
    fld ft0,(t0)
    la t0,IDXzero
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, END_LOOP_1
    la    a0, STR4
    li    a7, 4
    ecall
    la t0,IDXcounter
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXcounter
    fld fa0,(t0)
    la t0,IDXone
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    la t0,IDXcounter
    fsd fa0,(t0)
    la    a0, STR5
    li    a7, 4
    ecall
    la t0,IDXcounter
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    j LOOP_0
END_LOOP_1:
    la    a0, STR6
    li    a7, 4
    ecall
    la t0,IDXcounter
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
