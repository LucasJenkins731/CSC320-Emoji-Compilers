# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
VAL1:    .double 0.0
VAL2:    .double 1.0
VAL3:    .double 1.0
VAL4:    .double 0.0
VAL5:    .double 0.0
VAL6:    .double 1.0
VAL7:    .double 1.0
VAL8:    .double 0.0
VAL9:    .double 0.0
VAL10:    .double 0.0
VAL11:    .double 1.0
VAL12:    .double 1.0
VAL13:    .double 0.0
VAL14:    .double 0.0
VAL15:    .double 0.0
VAL16:    .double 0.0
VAL17:    .double 1.0
VAL18:    .double 1.0
VAL19:    .double 1.0
VAL20:    .double 0.0
VAL21:    .double 0.0
VAL22:    .double 1.0
VAL23:    .double 1.0
IDXA:    .space 800
IDXb_idx:    .double 0.0
IDXB:    .space 800
IDXC:    .space 800
IDXs:    .double 0.0
IDXi:    .double 0.0
IDXj:    .double 0.0
IDXk:    .double 0.0
IDXidx:    .double 0.0
IDXa_idx:    .double 0.0
IDXn:    .double 0.0
IDXc_idx:    .double 0.0
    .text
    .globl main
main: 
    li    a7, 7
    ecall
    la t0,IDXn
    fsd fa0,(t0)
    la t0,VAL0
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
    la t0,VAL1
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
    la t0,IDXi
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXj
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXidx
    fsd fa0,(t0)
    la t0,IDXidx
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
    la t0,IDXj
    fld fa0,(t0)
    la t0,VAL2
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXj
    fsd fa0,(t0)
    j LOOP_0
END_LOOP_1:
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
    la t0,VAL5
    fld fa0,(t0)
    la t0,IDXj
    fsd fa0,(t0)
LOOP_4:
    la t0,IDXj
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_5
    la t0,IDXi
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXj
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXidx
    fsd fa0,(t0)
    la t0,IDXidx
    fld ft2,(t0)
    li    a7, 7
    ecall
    # Store 1D array element B[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXB  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXj
    fld fa0,(t0)
    la t0,VAL6
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXj
    fsd fa0,(t0)
    j LOOP_4
END_LOOP_5:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL7
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_6
END_LOOP_7:
    la t0,VAL8
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_10:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_11
    la t0,VAL9
    fld fa0,(t0)
    la t0,IDXj
    fsd fa0,(t0)
LOOP_8:
    la t0,IDXj
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_9
    la t0,IDXi
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXj
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXidx
    fsd fa0,(t0)
    la t0,IDXidx
    fld ft2,(t0)
    la t0,VAL10
    fld fa0,(t0)
    # Store 1D array element C[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXC  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXj
    fld fa0,(t0)
    la t0,VAL11
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXj
    fsd fa0,(t0)
    j LOOP_8
END_LOOP_9:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL12
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_10
END_LOOP_11:
    la t0,VAL13
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
LOOP_16:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_17
    la t0,VAL14
    fld fa0,(t0)
    la t0,IDXj
    fsd fa0,(t0)
LOOP_14:
    la t0,IDXj
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_15
    la t0,VAL15
    fld fa0,(t0)
    la t0,IDXs
    fsd fa0,(t0)
    la t0,VAL16
    fld fa0,(t0)
    la t0,IDXk
    fsd fa0,(t0)
LOOP_12:
    la t0,IDXk
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_13
    la t0,IDXi
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXk
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXa_idx
    fsd fa0,(t0)
    la t0,IDXk
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXj
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXb_idx
    fsd fa0,(t0)
    la t0,IDXs
    fld fa0,(t0)
    la t0,IDXa_idx
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXb_idx
    fld ft2,(t0)
    # Load 1D array element B[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXB  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    fmul.d ft0,ft0,ft1
    fadd.d fa0,fa0,ft0
    la t0,IDXs
    fsd fa0,(t0)
    la t0,IDXk
    fld fa0,(t0)
    la t0,VAL17
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXk
    fsd fa0,(t0)
    j LOOP_12
END_LOOP_13:
    la t0,IDXi
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXj
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXc_idx
    fsd fa0,(t0)
    la t0,IDXc_idx
    fld ft2,(t0)
    la t0,IDXs
    fld fa0,(t0)
    # Store 1D array element C[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXC  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXj
    fld fa0,(t0)
    la t0,VAL18
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXj
    fsd fa0,(t0)
    j LOOP_14
END_LOOP_15:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL19
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_16
END_LOOP_17:
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
    la t0,VAL21
    fld fa0,(t0)
    la t0,IDXj
    fsd fa0,(t0)
LOOP_18:
    la t0,IDXj
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_19
    la t0,IDXi
    fld fa0,(t0)
    la t0,IDXn
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXj
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXc_idx
    fsd fa0,(t0)
    la t0,IDXc_idx
    fld ft2,(t0)
    # Load 1D array element C[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXC  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXj
    fld fa0,(t0)
    la t0,VAL22
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXj
    fsd fa0,(t0)
    j LOOP_18
END_LOOP_19:
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL23
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    j LOOP_20
END_LOOP_21:
end:
    li    a0, 0
    li    a7, 93
    ecall
