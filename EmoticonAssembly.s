# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
STR0:    .asciz "=== COLLATZ CONJECTURE ==="
STR1:    .asciz "Enter a number:"
VAL2:    .double 0.0
STR3:    .asciz "Starting Collatz sequence for:"
VAL4:    .double 1.0
VAL5:    .double 2.0
VAL6:    .double 0.0
VAL7:    .double 2.0
VAL8:    .double 3.0
VAL9:    .double 1.0
VAL10:    .double 1.0
STR11:    .asciz "steps = "
STR12:    .asciz "max = "
IDXmax_val:    .double 0.0
IDXsteps:    .double 0.0
IDXn:    .double 0.0
    .text
main: 
    la    a0, STR0
    li    a7, 4
    ecall
    la    a0, STR1
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXsteps
    fsd fa0,(t0)
    la t0,IDXn
    fld fa0,(t0)
    la t0,IDXmax_val
    fsd fa0,(t0)
    la    a0, STR3
    li    a7, 4
    ecall
    la t0,IDXn
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
LOOP_6:
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL4
    fld ft1,(t0)
    # Compare ft0 :!=) ft1 (jump if false)
    feq.d t0, ft0, ft1
    bnez t0, END_LOOP_7
    la t0,IDXn
    fld ft0,(t0)
    la t0,IDXmax_val
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSE_0
    la t0,IDXn
    fld fa0,(t0)
    la t0,IDXmax_val
    fsd fa0,(t0)
ELSE_0:
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL5
    fld ft1,(t0)
    # Modulo operation: ft0 % ft1
    fcvt.w.d t0, ft0  # Convert left operand to int
    fcvt.w.d t1, ft1  # Convert right operand to int
    rem t0, t0, t1             # Integer modulo
    fcvt.d.w ft0, t0  # Convert result back to double
    la t0,VAL6
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSE_2
    la t0,IDXn
    fld fa0,(t0)
    la t0,VAL7
    fld ft0,(t0)
    fdiv.d fa0,fa0,ft0
    la t0,IDXn
    fsd fa0,(t0)
    j END_IF_3
ELSE_2:
    la t0,VAL8
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,VAL9
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXn
    fsd fa0,(t0)
END_IF_3:
    la t0,IDXsteps
    fld fa0,(t0)
    la t0,VAL10
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXsteps
    fsd fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    la t0,IDXmax_val
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSE_4
    la t0,IDXn
    fld fa0,(t0)
    la t0,IDXmax_val
    fsd fa0,(t0)
ELSE_4:
    j LOOP_6
END_LOOP_7:
    la    a0, STR11
    li    a7, 4
    ecall
    la t0,IDXsteps
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR12
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
