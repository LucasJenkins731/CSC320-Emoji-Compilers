# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
VAL1:    .double 0.0
VAL2:    .double 0.0
VAL3:    .double 0.0
VAL4:    .double 0.0
VAL5:    .double 0.0
VAL6:    .double 1.0
VAL7:    .double 0.0
VAL8:    .double 1.0
VAL9:    .double 1.0
VAL10:    .double 1.0
VAL11:    .double 0.0
VAL12:    .double 0.0
VAL13:    .double 1.0
VAL14:    .double 0.0
VAL15:    .double 1.0
VAL16:    .double 1.0
VAL17:    .double 1.0
STR18:    .asciz "sum = "
STR19:    .asciz "min = "
STR20:    .asciz "max = "
STR21:    .asciz "pos = "
STR22:    .asciz "neg = "
STR23:    .asciz "zero = "
IDXfirst_val:    .double 0.0
IDXzero:    .double 0.0
IDXmn:    .double 0.0
IDXneg:    .double 0.0
IDXtotal:    .double 0.0
IDXpos:    .double 0.0
IDXx:    .double 0.0
IDXi:    .double 0.0
IDXmx:    .double 0.0
IDXn:    .double 0.0
    .text
    .globl main
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXn
    fsd fa0,(t0)
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
    la t0,VAL1
    fld fa0,(t0)
    la t0,IDXfirst_val
    fsd fa0,(t0)
    li    a7, 7
    ecall
    la t0,IDXfirst_val
    fsd fa0,(t0)
    la t0,IDXfirst_val
    fld fa0,(t0)
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,IDXfirst_val
    fld fa0,(t0)
    la t0,IDXmn
    fsd fa0,(t0)
    la t0,IDXfirst_val
    fld fa0,(t0)
    la t0,IDXmx
    fsd fa0,(t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXpos
    fsd fa0,(t0)
    la t0,VAL3
    fld fa0,(t0)
    la t0,IDXneg
    fsd fa0,(t0)
    la t0,VAL4
    fld fa0,(t0)
    la t0,IDXzero
    fsd fa0,(t0)
    la t0,IDXfirst_val
    fld ft0,(t0)
    la t0,VAL5
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_0
    la t0,VAL6
    fld fa0,(t0)
    la t0,IDXpos
    fsd fa0,(t0)
    j END_IF_1
ELSEIF_0:
    la t0,VAL9
    fld fa0,(t0)
    la t0,IDXzero
    fsd fa0,(t0)
END_IF_1:
    la t0,VAL10
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_8:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_9
    la t0,VAL11
    fld fa0,(t0)
    la t0,IDXx
    fsd fa0,(t0)
    li    a7, 7
    ecall
    la t0,IDXx
    fsd fa0,(t0)
    la t0,IDXtotal
    fld fa0,(t0)
    la t0,IDXx
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,IDXx
    fld ft0,(t0)
    la t0,IDXmn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, ELSEIF_2
    la t0,IDXx
    fld fa0,(t0)
    la t0,IDXmn
    fsd fa0,(t0)
    j END_IF_3
ELSEIF_2:
END_IF_3:
    la t0,IDXx
    fld ft0,(t0)
    la t0,IDXmx
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_4
    la t0,IDXx
    fld fa0,(t0)
    la t0,IDXmx
    fsd fa0,(t0)
    j END_IF_5
ELSEIF_4:
END_IF_5:
    la t0,IDXx
    fld ft0,(t0)
    la t0,VAL12
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_6
    la t0,IDXpos
    fld fa0,(t0)
    la t0,VAL13
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXpos
    fsd fa0,(t0)
    j END_IF_7
ELSEIF_6:
    la t0,IDXzero
    fld fa0,(t0)
    la t0,VAL16
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXzero
    fsd fa0,(t0)
END_IF_7:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL17
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_8
END_LOOP_9:
    la    a0, STR18
    li    a7, 4
    ecall
    la t0,IDXtotal
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR19
    li    a7, 4
    ecall
    la t0,IDXmn
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR20
    li    a7, 4
    ecall
    la t0,IDXmx
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR21
    li    a7, 4
    ecall
    la t0,IDXpos
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR22
    li    a7, 4
    ecall
    la t0,IDXneg
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR23
    li    a7, 4
    ecall
    la t0,IDXzero
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
