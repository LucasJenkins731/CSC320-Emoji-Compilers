# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
PARAM_calculateMean_sum:    .double 0.0
PARAM_calculateMean_count:    .double 0.0
VAL0:    .double 0.0
VAL1:    .double 0.0
PARAM_sumArrayElements_start:    .double 0.0
PARAM_sumArrayElements_count:    .double 0.0
VAL2:    .double 0.0
VAL3:    .double 0.0
VAL4:    .double 1.0
PARAM_findMinValue_start:    .double 0.0
PARAM_findMinValue_count:    .double 0.0
VAL5:    .double 0.0
VAL6:    .double 0.0
VAL7:    .double 1.0
VAL8:    .double 1.0
PARAM_findMaxValue_start:    .double 0.0
PARAM_findMaxValue_count:    .double 0.0
VAL9:    .double 0.0
VAL10:    .double 0.0
VAL11:    .double 1.0
VAL12:    .double 1.0
VAL13:    .double 0.0
STR14:    .asciz "Array dimensions N must not be negative. Try again."
VAL15:    .double 0.0
VAL16:    .double 1.0
STR17:    .asciz "Array contents:"
VAL18:    .double 0.0
VAL19:    .double 1.0
VAL20:    .double 0.0
VAL21:    .double 0.0
VAL22:    .double 0.0
STR23:    .asciz "sum ="
STR24:    .asciz "mean ="
STR25:    .asciz "min ="
STR26:    .asciz "max ="
IDXval:    .double 0.0
IDXA:    .space 800
IDXtotal:    .double 0.0
IDXmaxVal:    .double 0.0
IDXmax_val:    .double 0.0
IDXminVal:    .double 0.0
IDXmean:    .double 0.0
IDXi:    .double 0.0
IDXmin_val:    .double 0.0
IDXidx:    .double 0.0
IDXn:    .double 0.0
    .text
    .globl main
main: 
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
LOOP_16:
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL13
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_17
    la    a0, STR14
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
    j LOOP_16
END_LOOP_17:
    la t0,VAL15
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
    la t0,VAL16
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_18
END_LOOP_19:
    la    a0, STR17
    li    a7, 4
    ecall
    la t0,VAL18
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_20:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_21
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
    la t0,VAL19
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_20
END_LOOP_21:
    la t0,VAL20
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,IDXn
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    # Call function sumArrayElements
    jal   FUNC_sumArrayElements
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,IDXtotal
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,IDXn
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    # Call function calculateMean
    jal   FUNC_calculateMean
    la t0,IDXmean
    fsd fa0,(t0)
    la t0,VAL21
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,IDXn
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    # Call function findMinValue
    jal   FUNC_findMinValue
    la t0,IDXmin_val
    fsd fa0,(t0)
    la t0,VAL22
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,IDXn
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    # Call function findMaxValue
    jal   FUNC_findMaxValue
    la t0,IDXmax_val
    fsd fa0,(t0)
    la    a0, STR23
    li    a7, 4
    ecall
    la t0,IDXtotal
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR24
    li    a7, 4
    ecall
    la t0,IDXmean
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR25
    li    a7, 4
    ecall
    la t0,IDXmin_val
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR26
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
FUNC_calculateMean:
    # Function calculateMean with 2 parameters
    la    t0, PARAM_calculateMean_sum
    fsd   fa0, (t0)
    la    t0, PARAM_calculateMean_count
    fsd   fa1, (t0)
    la    t0, PARAM_calculateMean_count  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    la t0,VAL0
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_0
    la    t0, PARAM_calculateMean_sum  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la    t0, PARAM_calculateMean_count  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    fdiv.d fa0,fa0,ft0
    # Return from function
    ret
    j END_IF_1
ELSEIF_0:
END_IF_1:
    la t0,VAL1
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_sumArrayElements:
    # Function sumArrayElements with 2 parameters
    la    t0, PARAM_sumArrayElements_start
    fsd   fa0, (t0)
    la    t0, PARAM_sumArrayElements_count
    fsd   fa1, (t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,VAL3
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_2:
    la t0,IDXi
    fld ft0,(t0)
    la    t0, PARAM_sumArrayElements_count  # Load parameter address
    fld   ft1, (t0)  # Load parameter value
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_3
    la    t0, PARAM_sumArrayElements_start  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXi
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXidx
    fsd fa0,(t0)
    la t0,IDXtotal
    fld fa0,(t0)
    la t0,IDXidx
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
    la t0,VAL4
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_2
END_LOOP_3:
    la t0,IDXtotal
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_findMinValue:
    # Function findMinValue with 2 parameters
    la    t0, PARAM_findMinValue_start
    fsd   fa0, (t0)
    la    t0, PARAM_findMinValue_count
    fsd   fa1, (t0)
    la    t0, PARAM_findMinValue_count  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    la t0,VAL5
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_4
    la t0,VAL6
    fld fa0,(t0)
    # Return from function
    ret
    j END_IF_5
ELSEIF_4:
END_IF_5:
    la    t0, PARAM_findMinValue_start  # Load parameter address
    fld   ft2, (t0)  # Load parameter value
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXminVal
    fsd fa0,(t0)
    la t0,VAL7
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_8:
    la t0,IDXi
    fld ft0,(t0)
    la    t0, PARAM_findMinValue_count  # Load parameter address
    fld   ft1, (t0)  # Load parameter value
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_9
    la    t0, PARAM_findMinValue_start  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXi
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXidx
    fsd fa0,(t0)
    la t0,IDXidx
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXminVal
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, ELSEIF_6
    la t0,IDXidx
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXminVal
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
    la t0,IDXminVal
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_findMaxValue:
    # Function findMaxValue with 2 parameters
    la    t0, PARAM_findMaxValue_start
    fsd   fa0, (t0)
    la    t0, PARAM_findMaxValue_count
    fsd   fa1, (t0)
    la    t0, PARAM_findMaxValue_count  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    la t0,VAL9
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_10
    la t0,VAL10
    fld fa0,(t0)
    # Return from function
    ret
    j END_IF_11
ELSEIF_10:
END_IF_11:
    la    t0, PARAM_findMaxValue_start  # Load parameter address
    fld   ft2, (t0)  # Load parameter value
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXmaxVal
    fsd fa0,(t0)
    la t0,VAL11
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_14:
    la t0,IDXi
    fld ft0,(t0)
    la    t0, PARAM_findMaxValue_count  # Load parameter address
    fld   ft1, (t0)  # Load parameter value
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_15
    la    t0, PARAM_findMaxValue_start  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXi
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXidx
    fsd fa0,(t0)
    la t0,IDXidx
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXmaxVal
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_12
    la t0,IDXidx
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXmaxVal
    fsd fa0,(t0)
    j END_IF_13
ELSEIF_12:
END_IF_13:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL12
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_14
END_LOOP_15:
    la t0,IDXmaxVal
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
