# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 5.0
VAL1:    .double 0.0
VAL2:    .double 0.0
VAL3:    .double 0.0
VAL4:    .double 0.0
VAL5:    .double 0.0
VAL6:    .double 0.0
STR7:    .asciz "Please enter 5 array elements:"
VAL8:    .double 0.0
VAL9:    .double 1.0
VAL10:    .double 2.0
VAL11:    .double 3.0
VAL12:    .double 4.0
VAL13:    .double 0.0
VAL14:    .double 1.0
VAL15:    .double 0.0
VAL16:    .double 0.0
VAL17:    .double 1.0
VAL18:    .double 1.0
VAL19:    .double 1.0
VAL20:    .double 2.0
VAL21:    .double 1.0
VAL22:    .double 1.0
VAL23:    .double 2.0
VAL24:    .double 2.0
VAL25:    .double 2.0
VAL26:    .double 3.0
VAL27:    .double 2.0
VAL28:    .double 2.0
VAL29:    .double 3.0
VAL30:    .double 3.0
VAL31:    .double 3.0
VAL32:    .double 4.0
VAL33:    .double 3.0
VAL34:    .double 3.0
VAL35:    .double 4.0
VAL36:    .double 4.0
VAL37:    .double 0.0
VAL38:    .double 1.0
VAL39:    .double 0.0
VAL40:    .double 0.0
VAL41:    .double 1.0
VAL42:    .double 1.0
VAL43:    .double 1.0
VAL44:    .double 2.0
VAL45:    .double 1.0
VAL46:    .double 1.0
VAL47:    .double 2.0
VAL48:    .double 2.0
VAL49:    .double 2.0
VAL50:    .double 3.0
VAL51:    .double 2.0
VAL52:    .double 2.0
VAL53:    .double 3.0
VAL54:    .double 3.0
VAL55:    .double 0.0
VAL56:    .double 1.0
VAL57:    .double 0.0
VAL58:    .double 0.0
VAL59:    .double 1.0
VAL60:    .double 1.0
VAL61:    .double 1.0
VAL62:    .double 2.0
VAL63:    .double 1.0
VAL64:    .double 1.0
VAL65:    .double 2.0
VAL66:    .double 2.0
VAL67:    .double 0.0
VAL68:    .double 1.0
VAL69:    .double 0.0
VAL70:    .double 0.0
VAL71:    .double 1.0
VAL72:    .double 1.0
STR73:    .asciz "Sorted array:"
VAL74:    .double 0.0
VAL75:    .double 1.0
VAL76:    .double 2.0
VAL77:    .double 3.0
VAL78:    .double 4.0
STR79:    .asciz "Enter value to search:"
VAL80:    .double 0.0
VAL81:    .double 0.0
VAL82:    .double 1.0
VAL83:    .double 1.0
VAL84:    .double 2.0
VAL85:    .double 2.0
VAL86:    .double 3.0
VAL87:    .double 3.0
VAL88:    .double 4.0
VAL89:    .double 4.0
VAL90:    .double 5.0
VAL91:    .double 0.0
STR92:    .asciz "found at index"
VAL93:    .double 1.0
VAL94:    .double 0.0
STR95:    .asciz "not found"
IDXarr:    .space 40
IDXtemp:    .double 0.0
IDXfound:    .double 0.0
IDXi:    .double 0.0
IDXj:    .double 0.0
IDXqueries:    .double 0.0
IDXn:    .double 0.0
IDXtarget:    .double 0.0
    .text
    .globl main
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXn
    fsd fa0,(t0)
    la t0,VAL1
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXj
    fsd fa0,(t0)
    la t0,VAL3
    fld fa0,(t0)
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL4
    fld fa0,(t0)
    la t0,IDXqueries
    fsd fa0,(t0)
    la t0,VAL5
    fld fa0,(t0)
    la t0,IDXtarget
    fsd fa0,(t0)
    la t0,VAL6
    fld fa0,(t0)
    la t0,IDXfound
    fsd fa0,(t0)
    la    a0, STR7
    li    a7, 4
    ecall
    la t0,VAL8
    fld ft2,(t0)
    li    a7, 7
    ecall
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL9
    fld ft2,(t0)
    li    a7, 7
    ecall
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL10
    fld ft2,(t0)
    li    a7, 7
    ecall
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL11
    fld ft2,(t0)
    li    a7, 7
    ecall
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL12
    fld ft2,(t0)
    li    a7, 7
    ecall
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL13
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL14
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_0
    la t0,VAL15
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL16
    fld ft2,(t0)
    la t0,VAL17
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL18
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_1
ELSEIF_0:
END_IF_1:
    la t0,VAL19
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL20
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_2
    la t0,VAL21
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL22
    fld ft2,(t0)
    la t0,VAL23
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL24
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_3
ELSEIF_2:
END_IF_3:
    la t0,VAL25
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL26
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_4
    la t0,VAL27
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL28
    fld ft2,(t0)
    la t0,VAL29
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL30
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_5
ELSEIF_4:
END_IF_5:
    la t0,VAL31
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL32
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_6
    la t0,VAL33
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL34
    fld ft2,(t0)
    la t0,VAL35
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL36
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_7
ELSEIF_6:
END_IF_7:
    la t0,VAL37
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL38
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_8
    la t0,VAL39
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL40
    fld ft2,(t0)
    la t0,VAL41
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL42
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_9
ELSEIF_8:
END_IF_9:
    la t0,VAL43
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL44
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_10
    la t0,VAL45
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL46
    fld ft2,(t0)
    la t0,VAL47
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL48
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_11
ELSEIF_10:
END_IF_11:
    la t0,VAL49
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL50
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_12
    la t0,VAL51
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL52
    fld ft2,(t0)
    la t0,VAL53
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL54
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_13
ELSEIF_12:
END_IF_13:
    la t0,VAL55
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL56
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_14
    la t0,VAL57
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL58
    fld ft2,(t0)
    la t0,VAL59
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL60
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_15
ELSEIF_14:
END_IF_15:
    la t0,VAL61
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL62
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_16
    la t0,VAL63
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL64
    fld ft2,(t0)
    la t0,VAL65
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL66
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_17
ELSEIF_16:
END_IF_17:
    la t0,VAL67
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,VAL68
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft1, (t0)   # Load element
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_18
    la t0,VAL69
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL70
    fld ft2,(t0)
    la t0,VAL71
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL72
    fld ft2,(t0)
    la t0,IDXtemp
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    j END_IF_19
ELSEIF_18:
END_IF_19:
    la    a0, STR73
    li    a7, 4
    ecall
    la t0,VAL74
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,VAL75
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,VAL76
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,VAL77
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,VAL78
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR79
    li    a7, 4
    ecall
    li    a7, 7
    ecall
    la t0,IDXtarget
    fsd fa0,(t0)
    la t0,VAL80
    fld fa0,(t0)
    la t0,IDXfound
    fsd fa0,(t0)
    la t0,VAL81
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXtarget
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_20
    la t0,VAL82
    fld fa0,(t0)
    la t0,IDXfound
    fsd fa0,(t0)
    j END_IF_21
ELSEIF_20:
END_IF_21:
    la t0,VAL83
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXtarget
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_22
    la t0,VAL84
    fld fa0,(t0)
    la t0,IDXfound
    fsd fa0,(t0)
    j END_IF_23
ELSEIF_22:
END_IF_23:
    la t0,VAL85
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXtarget
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_24
    la t0,VAL86
    fld fa0,(t0)
    la t0,IDXfound
    fsd fa0,(t0)
    j END_IF_25
ELSEIF_24:
END_IF_25:
    la t0,VAL87
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXtarget
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_26
    la t0,VAL88
    fld fa0,(t0)
    la t0,IDXfound
    fsd fa0,(t0)
    j END_IF_27
ELSEIF_26:
END_IF_27:
    la t0,VAL89
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    la t0,IDXtarget
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_28
    la t0,VAL90
    fld fa0,(t0)
    la t0,IDXfound
    fsd fa0,(t0)
    j END_IF_29
ELSEIF_28:
END_IF_29:
    la t0,IDXfound
    fld ft0,(t0)
    la t0,VAL91
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_30
    la    a0, STR92
    li    a7, 4
    ecall
    la t0,IDXfound
    fld fa0,(t0)
    la t0,VAL93
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    j END_IF_31
ELSEIF_30:
END_IF_31:
    la t0,IDXfound
    fld ft0,(t0)
    la t0,VAL94
    fld ft1,(t0)
    # Compare ft0 :==) ft1 (jump if false)
    feq.d t0, ft0, ft1
    beqz t0, ELSEIF_32
    la    a0, STR95
    li    a7, 4
    ecall
    j END_IF_33
ELSEIF_32:
END_IF_33:
end:
    li    a0, 0
    li    a7, 93
    ecall
