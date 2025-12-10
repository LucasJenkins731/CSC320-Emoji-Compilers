# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
VAL1:    .double 1.0
VAL2:    .double 1.0
VAL3:    .double 2.0
VAL4:    .double 2.0
VAL5:    .double 3.0
STR6:    .asciz "Array element 1: "
VAL7:    .double 1.0
VAL8:    .double 0.0
VAL9:    .double 1.0
VAL10:    .double 3.0
STR11:    .asciz "arr[0] + arr[1] = "
VAL12:    .double 3.0
IDXarr:    .space 40
IDXtemp:    .double 0.0
    .text
main: 
    la t0,VAL0
    fld ft2,(t0)
    la t0,VAL1
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL2
    fld ft2,(t0)
    la t0,VAL3
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL4
    fld ft2,(t0)
    la t0,VAL5
    fld fa0,(t0)
    # Store 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la    a0, STR6
    li    a7, 4
    ecall
    la t0,VAL7
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
    la t0,VAL8
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    la t0,VAL9
    fld ft2,(t0)
    # Load 1D array element arr[ft2]
    fcvt.w.d t0, ft2  # Convert index to int
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXarr  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld ft0, (t0)   # Load element
    fadd.d fa0,fa0,ft0
    la t0,IDXtemp
    fsd fa0,(t0)
    la t0,VAL10
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
    la    a0, STR11
    li    a7, 4
    ecall
    la t0,VAL12
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
end:
    li    a0, 0
    li    a7, 93
    ecall
