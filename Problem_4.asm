# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
STR1:    .asciz "Array size N must be positive. Try again."
VAL2:    .double 0.0
VAL3:    .double 1.0
VAL4:    .double 0.0
VAL5:    .double 0.0
VAL6:    .double 0.0
VAL7:    .double 1.0
VAL8:    .double 1.0
VAL9:    .double 0.0
VAL10:    .double 0.0
VAL11:    .double 1.0
VAL12:    .double 1.0
STR13:    .asciz "mean ="
STR14:    .asciz "min ="
STR15:    .asciz "max ="
STR16:    .asciz "above_mean ="
IDXval:    .double 0.0
IDXmn:    .double 0.0
IDXtotal:    .double 0.0
IDXT:    .space 800
IDXmean:    .double 0.0
IDXcount_above:    .double 0.0
IDXi:    .double 0.0
IDXmx:    .double 0.0
IDXn:    .double 0.0
    .text
    .globl main
main: 
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
LOOP_0:
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL0
    fld ft1,(t0)
    # Compare ft0 :<=) ft1 (jump if false)
    fle.d t0, ft0, ft1
    beqz t0, END_LOOP_1
    la    a0, STR1
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
    j LOOP_0
END_LOOP_1:
    la t0,VAL2
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
    la t0,IDXi
    fld ft2,(t0)
    li    a7, 7
    ecall
    # Store 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL3
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_2
END_LOOP_3:
    la t0,VAL4
    fld ft2,(t0)
    # Load 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,VAL5
    fld ft2,(t0)
    # Load 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXmn
    fsd fa0,(t0)
    la t0,VAL6
    fld ft2,(t0)
    # Load 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXmx
    fsd fa0,(t0)
    la t0,VAL7
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
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXval
    fsd fa0,(t0)
    la t0,IDXtotal
    fld fa0,(t0)
    la t0,IDXval
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,IDXval
    fld ft0,(t0)
    la t0,IDXmn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, ELSEIF_4
    la t0,IDXval
    fld fa0,(t0)
    la t0,IDXmn
    fsd fa0,(t0)
    j END_IF_5
ELSEIF_4:
END_IF_5:
    la t0,IDXval
    fld ft0,(t0)
    la t0,IDXmx
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_6
    la t0,IDXval
    fld fa0,(t0)
    la t0,IDXmx
    fsd fa0,(t0)
    j END_IF_7
ELSEIF_6:
END_IF_7:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL8
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_8
END_LOOP_9:
    la t0,IDXtotal
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fdiv.d fa0,fa0,ft0
    la t0,IDXmean
    fsd fa0,(t0)
    la t0,VAL9
    fld fa0,(t0)
    la t0,IDXcount_above
    fsd fa0,(t0)
    la t0,VAL10
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_12:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_13
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXmean
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_10
    la t0,IDXcount_above
    fld fa0,(t0)
    la t0,VAL11
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXcount_above
    fsd fa0,(t0)
    j END_IF_11
ELSEIF_10:
END_IF_11:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL12
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_12
END_LOOP_13:
    la    a0, STR13
    li    a7, 4
    ecall
    la t0,IDXmean
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR14
    li    a7, 4
    ecall
    la t0,IDXmn
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR15
    li    a7, 4
    ecall
    la t0,IDXmx
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR16
    li    a7, 4
    ecall
    la t0,IDXcount_above
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
