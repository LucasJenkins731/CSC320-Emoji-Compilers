# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
PARAM_bubbleSort_start:    .double 0.0
PARAM_bubbleSort_count:    .double 0.0
VAL0:    .double 0.0
VAL1:    .double 1.0
VAL2:    .double 1.0
VAL3:    .double 1.0
VAL4:    .double 1.0
VAL5:    .double 0.0
PARAM_printArray_start:    .double 0.0
PARAM_printArray_count:    .double 0.0
STR6:    .asciz "Sorted array:"
VAL7:    .double 0.0
VAL8:    .double 1.0
VAL9:    .double 0.0
PARAM_linearSearch_start:    .double 0.0
PARAM_linearSearch_count:    .double 0.0
PARAM_linearSearch_target:    .double 0.0
VAL10:    .double 0.0
VAL11:    .double 1.0
VAL12:    .double -1.0
PARAM_getMidpoint_left:    .double 0.0
PARAM_getMidpoint_right:    .double 0.0
VAL13:    .double 2.0
PARAM_binarySearchIterative_left:    .double 0.0
PARAM_binarySearchIterative_right:    .double 0.0
PARAM_binarySearchIterative_target:    .double 0.0
VAL14:    .double 2.0
VAL15:    .double 1.0
VAL16:    .double 1.0
VAL17:    .double -1.0
VAL18:    .double 0.0
STR19:    .asciz "Array dimensions N must be positive. Try again."
VAL20:    .double 0.0
VAL21:    .double 1.0
VAL22:    .double 0.0
VAL23:    .double 0.0
VAL24:    .double 0.0
VAL25:    .double 0.0
VAL26:    .double 1.0
VAL27:    .double -1.0
STR28:    .asciz "not found"
VAL29:    .double -1.0
STR30:    .asciz "found at index"
VAL31:    .double 1.0
IDXA:    .space 800
IDXtemp:    .double 0.0
IDXpass:    .double 0.0
IDXi:    .double 0.0
IDXmid:    .double 0.0
IDXqueryCount:    .double 0.0
IDXn:    .double 0.0
IDXtarget:    .double 0.0
IDXresult:    .double 0.0
IDXq:    .double 0.0
IDXcurrentLeft:    .double 0.0
IDXcurrentRight:    .double 0.0
IDXlimit:    .double 0.0
IDXidx:    .double 0.0
IDXnextIdx:    .double 0.0
    .text
    .globl main
main: 
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
LOOP_18:
    la t0,IDXn
    fld ft0,(t0)
    la t0,VAL18
    fld ft1,(t0)
    # Compare ft0 :<=) ft1 (jump if false)
    fle.d t0, ft0, ft1
    beqz t0, END_LOOP_19
    la    a0, STR19
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
    j LOOP_18
END_LOOP_19:
    la t0,VAL20
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
    li    a7, 7
    ecall
    # Store 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL21
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_20
END_LOOP_21:
    la t0,VAL22
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,IDXn
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    # Call function bubbleSort
    jal   FUNC_bubbleSort
    la t0,IDXresult
    fsd fa0,(t0)
    la t0,VAL23
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,IDXn
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    # Call function printArray
    jal   FUNC_printArray
    la t0,IDXresult
    fsd fa0,(t0)
    li    a7, 7
    ecall
    la t0,IDXq
    fsd fa0,(t0)
    la t0,VAL24
    fld fa0,(t0)
    la t0,IDXqueryCount
    fsd fa0,(t0)
LOOP_26:
    la t0,IDXqueryCount
    fld ft0,(t0)
    la t0,IDXq
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_27
    li    a7, 7
    ecall
    la t0,IDXtarget
    fsd fa0,(t0)
    la t0,VAL25
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,IDXn
    fld fa0,(t0)
    la t0,VAL26
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    fmv.d ft1, fa0
    la t0,IDXtarget
    fld fa0,(t0)
    fmv.d fa2, fa0
    fmv.d fa0, ft1
    # Call function binarySearchIterative
    jal   FUNC_binarySearchIterative
    la t0,IDXresult
    fsd fa0,(t0)
    la t0,IDXresult
    fld ft0,(t0)
    la t0,VAL27
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_22
    la    a0, STR28
    li    a7, 4
    ecall
    j END_IF_23
ELSEIF_22:
END_IF_23:
    la t0,IDXresult
    fld ft0,(t0)
    la t0,VAL29
    fld ft1,(t0)
    # Compare ft0 :!=) ft1 (jump if false)
    feq.d t0, ft0, ft1
    bnez t0, ELSEIF_24
    la    a0, STR30
    li    a7, 4
    ecall
    la t0,IDXresult
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    j END_IF_25
ELSEIF_24:
END_IF_25:
    la t0,IDXqueryCount
    fld fa0,(t0)
    la t0,VAL31
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXqueryCount
    fsd fa0,(t0)
    j LOOP_26
END_LOOP_27:
end:
    li    a0, 0
    li    a7, 93
    ecall
FUNC_bubbleSort:
    # Function bubbleSort with 2 parameters
    la    t0, PARAM_bubbleSort_start
    fsd   fa0, (t0)
    la    t0, PARAM_bubbleSort_count
    fsd   fa1, (t0)
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXpass
    fsd fa0,(t0)
LOOP_4:
    la t0,IDXpass
    fld ft0,(t0)
    la    t0, PARAM_bubbleSort_count  # Load parameter address
    fld   ft1, (t0)  # Load parameter value
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_5
    la    t0, PARAM_bubbleSort_start  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXi
    fsd fa0,(t0)
    la    t0, PARAM_bubbleSort_start  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la    t0, PARAM_bubbleSort_count  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    fadd.d fa0,fa0,ft0
    la t0,IDXpass
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    la t0,VAL1
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    la t0,IDXlimit
    fsd fa0,(t0)
LOOP_2:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXlimit
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_3
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL2
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXnextIdx
    fsd fa0,(t0)
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXnextIdx
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_0
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,IDXi
    fld ft2,(t0)
    la t0,IDXnextIdx
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXnextIdx
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_1
ELSEIF_0:
END_IF_1:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL3
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_2
END_LOOP_3:
    la t0,IDXpass
    fld fa0,(t0)
    la t0,VAL4
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXpass
    fsd fa0,(t0)
    j LOOP_4
END_LOOP_5:
    la t0,VAL5
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_printArray:
    # Function printArray with 2 parameters
    la    t0, PARAM_printArray_start
    fsd   fa0, (t0)
    la    t0, PARAM_printArray_count
    fsd   fa1, (t0)
    la    a0, STR6
    li    a7, 4
    ecall
    la t0,VAL7
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_6:
    la t0,IDXi
    fld ft0,(t0)
    la    t0, PARAM_printArray_count  # Load parameter address
    fld   ft1, (t0)  # Load parameter value
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_7
    la    t0, PARAM_printArray_start  # Load parameter address
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
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL8
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_6
END_LOOP_7:
    la t0,VAL9
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_linearSearch:
    # Function linearSearch with 3 parameters
    la    t0, PARAM_linearSearch_start
    fsd   fa0, (t0)
    la    t0, PARAM_linearSearch_count
    fsd   fa1, (t0)
    la    t0, PARAM_linearSearch_target
    fsd   fa2, (t0)
    la t0,VAL10
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_10:
    la t0,IDXi
    fld ft0,(t0)
    la    t0, PARAM_linearSearch_count  # Load parameter address
    fld   ft1, (t0)  # Load parameter value
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_11
    la    t0, PARAM_linearSearch_start  # Load parameter address
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
    la    t0, PARAM_linearSearch_target  # Load parameter address
    fld   ft1, (t0)  # Load parameter value
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_8
    la t0,IDXidx
    fld fa0,(t0)
    # Return from function
    ret
    j END_IF_9
ELSEIF_8:
END_IF_9:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL11
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_10
END_LOOP_11:
    la t0,VAL12
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_getMidpoint:
    # Function getMidpoint with 2 parameters
    la    t0, PARAM_getMidpoint_left
    fsd   fa0, (t0)
    la    t0, PARAM_getMidpoint_right
    fsd   fa1, (t0)
    la    t0, PARAM_getMidpoint_left  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la    t0, PARAM_getMidpoint_right  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    fadd.d fa0,fa0,ft0
    la t0,VAL13
    fld ft0,(t0)
    fdiv.d fa0,fa0,ft0
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_binarySearchIterative:
    # Function binarySearchIterative with 3 parameters
    la    t0, PARAM_binarySearchIterative_left
    fsd   fa0, (t0)
    la    t0, PARAM_binarySearchIterative_right
    fsd   fa1, (t0)
    la    t0, PARAM_binarySearchIterative_target
    fsd   fa2, (t0)
    la    t0, PARAM_binarySearchIterative_left  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXcurrentLeft
    fsd fa0,(t0)
    la    t0, PARAM_binarySearchIterative_right  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXcurrentRight
    fsd fa0,(t0)
LOOP_16:
    la t0,IDXcurrentLeft
    fld ft0,(t0)
    la t0,IDXcurrentRight
    fld ft1,(t0)
    # Compare ft0 :<=) ft1 (jump if false)
    fle.d t0, ft0, ft1
    beqz t0, END_LOOP_17
    la t0,IDXcurrentLeft
    fld fa0,(t0)
    la t0,IDXcurrentRight
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,VAL14
    fld ft0,(t0)
    fdiv.d fa0,fa0,ft0
    la t0,IDXmid
    fsd fa0,(t0)
    la t0,IDXmid
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la    t0, PARAM_binarySearchIterative_target  # Load parameter address
    fld   ft1, (t0)  # Load parameter value
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_12
    la t0,IDXmid
    fld fa0,(t0)
    # Return from function
    ret
    j END_IF_13
ELSEIF_12:
END_IF_13:
    la    t0, PARAM_binarySearchIterative_target  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    la t0,IDXmid
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, ELSEIF_14
    la t0,IDXmid
    fld fa0,(t0)
    la t0,VAL15
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    la t0,IDXcurrentRight
    fsd fa0,(t0)
    j END_IF_15
ELSEIF_14:
    la t0,IDXmid
    fld fa0,(t0)
    la t0,VAL16
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXcurrentLeft
    fsd fa0,(t0)
END_IF_15:
    j LOOP_16
END_LOOP_17:
    la t0,VAL17
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
