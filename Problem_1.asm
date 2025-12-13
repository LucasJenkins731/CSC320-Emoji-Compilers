# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
VAL1:    .double 3.14
VAL2:    .double 2.0
IDXarea:    .double 0.0
IDXcircumference:    .double 0.0
IDXname:    .double 0.0
IDXpi:    .double 0.0
IDXradius:    .double 0.0
    .text
    .globl main
main: 
    li    a7, 7
    ecall
    la t0,IDXname
    fsd fa0,(t0)
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXradius
    fsd fa0,(t0)
    li    a7, 7
    ecall
    la t0,IDXradius
    fsd fa0,(t0)
    la t0,VAL1
    fld fa0,(t0)
    la t0,IDXpi
    fsd fa0,(t0)
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXpi
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXradius
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXcircumference
    fsd fa0,(t0)
    la t0,IDXpi
    fld fa0,(t0)
    la t0,IDXradius
    fld ft0,(t0)
    la t0,IDXradius
    fld ft1,(t0)
    fmul.d ft0,ft0,ft1
    fmul.d fa0,fa0,ft0
    la t0,IDXarea
    fsd fa0,(t0)
    la t0,IDXname
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXcircumference
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,IDXarea
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
