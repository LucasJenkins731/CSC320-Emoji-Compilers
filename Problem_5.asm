# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
VAL1:    .double 0.0
VAL2:    .double 0.0
VAL3:    .double 1.0
VAL4:    .double 0.0
VAL5:    .double 1.0
VAL6:    .double 0.0
VAL7:    .double 1.0
VAL8:    .double 1.0
VAL9:    .double 1.0
VAL10:    .double 1.0
VAL11:    .double 1.0
VAL12:    .double 1.0
VAL13:    .double 1.0
VAL14:    .double 1.0
VAL15:    .double 1.0
VAL16:    .double 1.0
VAL17:    .double 0.0
VAL18:    .double 0.0
VAL19:    .double 1.0
IDXval:    .double 0.0
IDXA:    .space 800
IDXmid:    .double 0.0
IDXi:    .double 0.0
IDXj:    .double 0.0
IDXright:    .double 0.0
IDXk:    .double 0.0
IDXn:    .double 0.0
IDXout:    .double 0.0
IDXp:    .double 0.0
IDXT:    .space 800
IDXsize:    .double 0.0
IDXleft:    .double 0.0
IDXidx:    .double 0.0
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
    la t0,IDXidx
    fsd fa0,(t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXidx
    fsd fa0,(t0)
nullnullnullnull    la t0,IDXidx
    fld fa0,(t0)
    la t0,VAL3
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXidx
    fsd fa0,(t0)
    la t0,VAL4
    fld fa0,(t0)
    la t0,IDXval
    fsd fa0,(t0)
    li    a7, 7
    ecall
    la t0,IDXval
    fsd fa0,(t0)
    la t0,IDXidx
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
    la t0,VAL5
    fld fa0,(t0)
    la t0,IDXsize
    fsd fa0,(t0)
LOOP_14:
    la t0,IDXsize
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_15
    la t0,VAL6
    fld fa0,(t0)
    la t0,IDXleft
    fsd fa0,(t0)
LOOP_12:
    la t0,IDXleft
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    la t0,VAL7
    fld ft0,(t0)
    fsub.d ft1,ft1,ft0
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_13
    la t0,IDXleft
    fld fa0,(t0)
    la t0,IDXsize
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXmid
    fsd fa0,(t0)
    la t0,IDXleft
    fld fa0,(t0)
    la t0,IDXsize
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXsize
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXright
    fsd fa0,(t0)
    la t0,IDXmid
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_0
    la t0,IDXn
    fld fa0,(t0)
    la t0,IDXmid
    fsd fa0,(t0)
    j END_IF_1
ELSEIF_0:
END_IF_1:
    la t0,IDXright
    fld ft0,(t0)
    la t0,IDXn
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_2
    la t0,IDXn
    fld fa0,(t0)
    la t0,IDXright
    fsd fa0,(t0)
    j END_IF_3
ELSEIF_2:
END_IF_3:
    la t0,IDXleft
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
    la t0,IDXmid
    fld fa0,(t0)
    la t0,IDXj
    fsd fa0,(t0)
    la t0,IDXleft
    fld fa0,(t0)
    la t0,IDXk
    fsd fa0,(t0)
LOOP_6:
    la t0,IDXi
    fld ft0,(t0)
    la t0,IDXmid
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_7
    la t0,IDXj
    fld ft0,(t0)
    la t0,IDXright
    fld ft1,(t0)
    # Compare ft0 :>=) ft1 (jump if false)
    fle.d t0, ft1, ft0
    beqz t0, ELSEIF_4
    la t0,IDXk
    fld ft2,(t0)
    la t0,IDXi
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXi
    fld fa0,(t0)
    la t0,VAL8
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXi
    fsd fa0,(t0)
    la t0,IDXk
    fld fa0,(t0)
    la t0,VAL9
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXk
    fsd fa0,(t0)
    j END_IF_5
ELSEIF_4:
    la t0,IDXk
    fld ft2,(t0)
    la t0,IDXj
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXj
    fld fa0,(t0)
    la t0,VAL12
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXj
    fsd fa0,(t0)
    la t0,IDXk
    fld fa0,(t0)
    la t0,VAL13
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXk
    fsd fa0,(t0)
END_IF_5:
    j LOOP_6
END_LOOP_7:
LOOP_8:
    la t0,IDXj
    fld ft0,(t0)
    la t0,IDXright
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_9
    la t0,IDXk
    fld ft2,(t0)
    la t0,IDXj
    fld ft2,(t0)
    # Load 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXj
    fld fa0,(t0)
    la t0,VAL14
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXj
    fsd fa0,(t0)
    la t0,IDXk
    fld fa0,(t0)
    la t0,VAL15
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXk
    fsd fa0,(t0)
    j LOOP_8
END_LOOP_9:
    la t0,IDXleft
    fld fa0,(t0)
    la t0,IDXp
    fsd fa0,(t0)
LOOP_10:
    la t0,IDXp
    fld ft0,(t0)
    la t0,IDXright
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, END_LOOP_11
    la t0,IDXp
    fld ft2,(t0)
    la t0,IDXp
    fld ft2,(t0)
    # Load 1D array element T[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXT  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element A[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXA  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,IDXp
    fld fa0,(t0)
    la t0,VAL16
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXp
    fsd fa0,(t0)
    j LOOP_10
END_LOOP_11:
    la t0,IDXleft
    fld fa0,(t0)
    la t0,IDXsize
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXsize
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXleft
    fsd fa0,(t0)
    j LOOP_12
END_LOOP_13:
    la t0,IDXsize
    fld fa0,(t0)
    la t0,IDXsize
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXsize
    fsd fa0,(t0)
    j LOOP_14
END_LOOP_15:
    la t0,VAL17
    fld fa0,(t0)
    la t0,IDXout
    fsd fa0,(t0)
    la t0,VAL18
    fld fa0,(t0)
    la t0,IDXout
    fsd fa0,(t0)
nullnullnullnull    la t0,IDXout
    fld fa0,(t0)
    la t0,VAL19
    fld ft0,(t0)
    fadd.d fa0,fa0,ft0
    la t0,IDXout
    fsd fa0,(t0)
    la t0,IDXout
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
end:
    li    a0, 0
    li    a7, 93
    ecall
