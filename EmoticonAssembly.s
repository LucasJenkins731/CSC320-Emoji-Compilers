# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
STR0:    .asciz "=== MATHEMATICAL VALIDATION ==="
VAL1:    .double 17.0
VAL2:    .double 5.0
VAL3:    .double 2.0
STR4:    .asciz "17 % 5:"
STR5:    .asciz "Expected: 2, Actual:"
STR6:    .asciz "PASS: Modulo correct"
STR7:    .asciz "FAIL: Modulo incorrect"
VAL8:    .double 20.0
VAL9:    .double 4.0
VAL10:    .double 0.0
STR11:    .asciz "20 % 4:"
STR12:    .asciz "Expected: 0, Actual:"
STR13:    .asciz "PASS: Modulo correct"
STR14:    .asciz "FAIL: Modulo incorrect"
VAL15:    .double 15.0
VAL16:    .double 15.0
VAL17:    .double 16.0
STR18:    .asciz "15 == 15:"
STR19:    .asciz "PASS: Equal comparison"
STR20:    .asciz "FAIL: Equal comparison"
STR21:    .asciz "15 != 16:"
STR22:    .asciz "PASS: Not-equal comparison"
STR23:    .asciz "FAIL: Not-equal comparison"
IDXactual:    .double 0.0
IDXactual2:    .double 0.0
IDXa:    .double 0.0
IDXb:    .double 0.0
IDXexpected2:    .double 0.0
IDXc:    .double 0.0
IDXval4:    .double 0.0
IDXval3:    .double 0.0
IDXval2:    .double 0.0
IDXval1:    .double 0.0
IDXexpected:    .double 0.0
    .text
main: 
    la    a0, STR0
    li    a7, 4
    ecall
    la t0,VAL1
    fld fa0,(t0)
    la t0,IDXval1
    fsd fa0,(t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXval2
    fsd fa0,(t0)
    la t0,VAL3
    fld fa0,(t0)
    la t0,IDXexpected
    fsd fa0,(t0)
    la t0,IDXval1
    fld fa0,(t0)
    la t0,IDXval2
    fld ft0,(t0)
    # Modulo operation: fa0 % ft0
    fcvt.w.d t0, fa0  # Convert left operand to int
    fcvt.w.d t1, ft0  # Convert right operand to int
    rem t0, t0, t1             # Integer modulo
    fcvt.d.w fa0, t0  # Convert result back to double
    la t0,IDXactual
    fsd fa0,(t0)
    la    a0, STR4
    li    a7, 4
    ecall
    la    a0, STR5
    li    a7, 4
    ecall
    la t0,IDXactual
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXactual
    fld ft0,(t0)
    la t0,IDXexpected
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSE_0
    la    a0, STR6
    li    a7, 4
    ecall
    j END_IF_1
ELSE_0:
    la    a0, STR7
    li    a7, 4
    ecall
END_IF_1:
    la t0,VAL8
    fld fa0,(t0)
    la t0,IDXval3
    fsd fa0,(t0)
    la t0,VAL9
    fld fa0,(t0)
    la t0,IDXval4
    fsd fa0,(t0)
    la t0,VAL10
    fld fa0,(t0)
    la t0,IDXexpected2
    fsd fa0,(t0)
    la t0,IDXval3
    fld fa0,(t0)
    la t0,IDXval4
    fld ft0,(t0)
    # Modulo operation: fa0 % ft0
    fcvt.w.d t0, fa0  # Convert left operand to int
    fcvt.w.d t1, ft0  # Convert right operand to int
    rem t0, t0, t1             # Integer modulo
    fcvt.d.w fa0, t0  # Convert result back to double
    la t0,IDXactual2
    fsd fa0,(t0)
    la    a0, STR11
    li    a7, 4
    ecall
    la    a0, STR12
    li    a7, 4
    ecall
    la t0,IDXactual2
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXactual2
    fld ft0,(t0)
    la t0,IDXexpected2
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSE_2
    la    a0, STR13
    li    a7, 4
    ecall
    j END_IF_3
ELSE_2:
    la    a0, STR14
    li    a7, 4
    ecall
END_IF_3:
    la t0,VAL15
    fld fa0,(t0)
    la t0,IDXa
    fsd fa0,(t0)
    la t0,VAL16
    fld fa0,(t0)
    la t0,IDXb
    fsd fa0,(t0)
    la t0,VAL17
    fld fa0,(t0)
    la t0,IDXc
    fsd fa0,(t0)
    la    a0, STR18
    li    a7, 4
    ecall
    la t0,IDXa
    fld ft0,(t0)
    la t0,IDXb
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSE_4
    la    a0, STR19
    li    a7, 4
    ecall
    j END_IF_5
ELSE_4:
    la    a0, STR20
    li    a7, 4
    ecall
END_IF_5:
    la    a0, STR21
    li    a7, 4
    ecall
    la t0,IDXa
    fld ft0,(t0)
    la t0,IDXc
    fld ft1,(t0)
    # Compare ft0 :!=) ft1 (jump if false)
    feq.d t0, ft0, ft1
    bnez t0, ELSE_6
    la    a0, STR22
    li    a7, 4
    ecall
    j END_IF_7
ELSE_6:
    la    a0, STR23
    li    a7, 4
    ecall
END_IF_7:
end:
    li    a0, 0
    li    a7, 93
    ecall
