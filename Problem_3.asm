# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
VAL1:    .double 1.0
VAL2:    .double 2.0
VAL3:    .double 0.0
VAL4:    .double 2.0
VAL5:    .double 3.0
VAL6:    .double 1.0
VAL7:    .double 1.0
STR8:    .asciz "steps ="
STR9:    .asciz "max ="
IDXmax_val:    .double 0.0
IDXsteps:    .double 0.0
IDXremainder:    .double 0.0
IDXn:    .double 0.0
    .text
    .globl main
main: 
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXsteps
    fsd fa0,(t0)
    la t0,IDXn
    fld fa0,(t0)
    la t0,IDXmax_val
    fsd fa0,(t0)
LOOP_4:
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL1
    fld ft1,(t0)
    # Compare ft0 :!=) ft1 (jump if false)
    feq.d t0, ft0, ft1
    bnez t0, END_LOOP_5
    la t0,IDXn
    fld ft0,(t0)
    la t0,IDXmax_val
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_0
    la t0,IDXn
    fld fa0,(t0)
    la t0,IDXmax_val
    fsd fa0,(t0)
    j END_IF_1
ELSEIF_0:
END_IF_1:
    la t0,IDXn
    fld fa0,(t0)
    la t0,VAL2
    fld ft0,(t0)
    # Modulo operation: fa0 % ft0
    fcvt.w.d t0, fa0  # Convert left operand to int
    fcvt.w.d t1, ft0  # Convert right operand to int
    rem t0, t0, t1             # Integer modulo
    fcvt.d.w fa0, t0  # Convert result back to double
    la t0,IDXremainder
    fsd fa0,(t0)
    la t0,IDXremainder
    fld ft0,(t0)
    la t0,VAL3
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_2
    la t0,IDXn
    fld fa0,(t0)
    la t0,VAL4
    fld ft0,(t0)
    fdiv.d fa0,fa0,ft0
    la t0,IDXn
    fsd fa0,(t0)
    j END_IF_3
ELSEIF_2:
    la t0,VAL5
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,VAL6
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXn
    fsd fa0,(t0)
END_IF_3:
    la t0,IDXsteps
    fld fa0,(t0)
    la t0,VAL7
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXsteps
    fsd fa0,(t0)
    j LOOP_4
END_LOOP_5:
    la t0,IDXn
    fld ft0,(t0)
    la t0,IDXmax_val
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_6
    la t0,IDXn
    fld fa0,(t0)
    la t0,IDXmax_val
    fsd fa0,(t0)
    j END_IF_7
ELSEIF_6:
END_IF_7:
    la    a0, STR8
    li    a7, 4
    ecall
    la t0,IDXsteps
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR9
    li    a7, 4
    ecall
    la t0,IDXmax_val
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
