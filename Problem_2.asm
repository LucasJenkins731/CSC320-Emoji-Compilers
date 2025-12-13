# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
VAL1:    .double 10000.0
VAL2:    .double 0.0
VAL3:    .double 40000.0
VAL4:    .double 10.0
VAL5:    .double 80000.0
VAL6:    .double 20.0
VAL7:    .double 30.0
VAL8:    .double 100.0
STR9:    .asciz "income ="
STR10:    .asciz "rate ="
STR11:    .asciz "tax ="
STR12:    .asciz "net ="
IDXincome:    .double 0.0
IDXrate:    .double 0.0
IDXtax:    .double 0.0
IDXnet:    .double 0.0
    .text
    .globl main
main: 
    li    a7, 7
    ecall
    la t0,IDXincome
    fsd fa0,(t0)
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXrate
    fsd fa0,(t0)
    la t0,IDXincome
    fld ft0,(t0)
    la t0,VAL1
    fld ft1,(t0)
    # Compare ft0 :<) ft1 (jump if false)
    flt.d t0, ft0, ft1
    beqz t0, ELSEIF_0
    la t0,VAL2
    fld fa0,(t0)
    la t0,IDXrate
    fsd fa0,(t0)
    j END_IF_1
ELSEIF_0:
    la t0,VAL7
    fld fa0,(t0)
    la t0,IDXrate
    fsd fa0,(t0)
END_IF_1:
    la t0,IDXrate
    fld fa0,(t0)
    la t0,VAL8
    fld ft0,(t0)
    fdiv.d fa0,fa0,ft0
    la t0,IDXincome
    fld ft0,(t0)
    fmul.d fa0,fa0,ft0
    la t0,IDXtax
    fsd fa0,(t0)
    la t0,IDXincome
    fld fa0,(t0)
    la t0,IDXtax
    fld ft0,(t0)
    fsub.d fa0,fa0,ft0
    la t0,IDXnet
    fsd fa0,(t0)
    la    a0, STR9
    li    a7, 4
    ecall
    la t0,IDXincome
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR10
    li    a7, 4
    ecall
    la t0,IDXrate
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR11
    li    a7, 4
    ecall
    la t0,IDXtax
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR12
    li    a7, 4
    ecall
    la t0,IDXnet
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
