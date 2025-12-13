# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
STR1:    .asciz "Array dimensions N must not be negative. Try again."
VAL2:    .double 0.0
VAL3:    .double 1.0
STR4:    .asciz "Array contents:"
VAL5:    .double 0.0
VAL6:    .double 1.0
VAL7:    .double 0.0
VAL8:    .double 0.0
VAL9:    .double 1.0
VAL10:    .double 0.0
VAL11:    .double 0.0
VAL12:    .double 0.0
VAL13:    .double 0.0
VAL14:    .double 0.0
VAL15:    .double 1.0
VAL16:    .double 1.0
VAL17:    .double 0.0
VAL18:    .double 0.0
VAL19:    .double 0.0
VAL20:    .double 1.0
VAL21:    .double 1.0
STR22:    .asciz "sum ="
STR23:    .asciz "mean ="
STR24:    .asciz "min ="
STR25:    .asciz "max ="
IDXval:    .double 0.0
IDXA:    .space 800
IDXtotal:    .double 0.0
IDXmax_val:    .double 0.0
IDXmean:    .double 0.0
IDXi:    .double 0.0
IDXmin_val:    .double 0.0
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
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
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
    li    a7, 7
    ecall
    la t0,IDXval
    fsd fa0,(t0)
    la t0,IDXi
    fld ft2,(t0)
    la t0,IDXval
    fld fa0,(t0)
    # Store 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
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
    la    a0, STR4
    li    a7, 4
    ecall
    la t0,VAL5
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_4:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_5
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL6
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_4
END_LOOP_5:
    la t0,VAL7
    fld fa0,(t0)
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,VAL8
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_6:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_7
    la t0,IDXtotal
    fld fa0,(t0)
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    fadd.d fa0,fa0,ft0
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL9
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_6
END_LOOP_7:
    la t0,VAL10
    fld fa0,(t0)
    la t0,IDXmean
    fsd fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL11
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_8
    la t0,IDXtotal
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fdiv.d fa0,fa0,ft0
    la t0,IDXmean
    fsd fa0,(t0)
    j END_IF_9
ELSEIF_8:
END_IF_9:
    la t0,VAL12
    fld fa0,(t0)
    la t0,IDXmin_val
    fsd fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL13
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_14
    la t0,VAL14
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXmin_val
    fsd fa0,(t0)
    la t0,VAL15
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
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXmin_val
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, ELSEIF_10
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXmin_val
    fsd fa0,(t0)
    j END_IF_11
ELSEIF_10:
END_IF_11:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL16
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_12
END_LOOP_13:
    j END_IF_15
ELSEIF_14:
END_IF_15:
    la t0,VAL17
    fld fa0,(t0)
    la t0,IDXmax_val
    fsd fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL18
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_20
    la t0,VAL19
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXmax_val
    fsd fa0,(t0)
    la t0,VAL20
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_18:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_19
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXmax_val
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_16
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXmax_val
    fsd fa0,(t0)
    j END_IF_17
ELSEIF_16:
END_IF_17:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL21
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_18
END_LOOP_19:
    j END_IF_21
ELSEIF_20:
END_IF_21:
    la    a0, STR22
    li    a7, 4
    ecall
    la t0,IDXtotal
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR23
    li    a7, 4
    ecall
    la t0,IDXmean
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR24
    li    a7, 4
    ecall
    la t0,IDXmin_val
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR25
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
