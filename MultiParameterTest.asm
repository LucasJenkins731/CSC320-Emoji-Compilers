# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
PARAM_addThree_x:    .double 0.0
PARAM_addThree_y:    .double 0.0
PARAM_addThree_z:    .double 0.0
PARAM_rectangleArea_width:    .double 0.0
PARAM_rectangleArea_height:    .double 0.0
PARAM_maxFour_a:    .double 0.0
PARAM_maxFour_b:    .double 0.0
PARAM_maxFour_c:    .double 0.0
PARAM_maxFour_d:    .double 0.0
VAL0:    .double 1.0
VAL1:    .double 2.0
VAL2:    .double 3.0
VAL3:    .double 5.0
VAL4:    .double 10.0
VAL5:    .double 2.0
VAL6:    .double 8.0
VAL7:    .double 3.0
VAL8:    .double 6.0
VAL9:    .double 10.0
VAL10:    .double 20.0
VAL11:    .double 30.0
VAL12:    .double 2.0
VAL13:    .double 3.0
IDXresult:    .double 0.0
IDXarea:    .double 0.0
IDXtotal:    .double 0.0
IDXmaximum:    .double 0.0
IDXsum:    .double 0.0
IDXmax1:    .double 0.0
    .text
    .globl main
main: 
    la t0,VAL0
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,VAL1
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    fmv.d ft1, fa0
    la t0,VAL2
    fld fa0,(t0)
    fmv.d fa2, fa0
    fmv.d fa0, ft1
    # Call function addThree
    jal   FUNC_addThree
    la t0,IDXsum
    fsd fa0,(t0)
    la t0,VAL3
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,VAL4
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    # Call function rectangleArea
    jal   FUNC_rectangleArea
    la t0,IDXarea
    fsd fa0,(t0)
    la t0,VAL5
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,VAL6
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    fmv.d ft1, fa0
    la t0,VAL7
    fld fa0,(t0)
    fmv.d fa2, fa0
    fmv.d fa0, ft1
    fmv.d ft2, fa0
    la t0,VAL8
    fld fa0,(t0)
    fmv.d fa3, fa0
    fmv.d fa0, ft2
    # Call function maxFour
    jal   FUNC_maxFour
    la t0,IDXmaximum
    fsd fa0,(t0)
    la t0,IDXsum
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
    la t0,IDXmaximum
    fld fa0,(t0)
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la t0,VAL9
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,VAL10
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    fmv.d ft1, fa0
    la t0,VAL11
    fld fa0,(t0)
    fmv.d fa2, fa0
    fmv.d fa0, ft1
    # Call function addThree
    jal   FUNC_addThree
    la t0,VAL12
    fld fa0,(t0)
    fmv.d ft0, fa0
    la t0,VAL13
    fld fa0,(t0)
    fmv.d fa1, fa0
    fmv.d fa0, ft0
    # Call function rectangleArea
    jal   FUNC_rectangleArea
    fmv.d ft0, fa0
    fadd.d fa0,fa0,ft0
    la t0,IDXtotal
    fsd fa0,(t0)
    la t0,IDXtotal
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
FUNC_addThree:
    # Function addThree with 3 parameters
    la    t0, PARAM_addThree_x
    fsd   fa0, (t0)
    la    t0, PARAM_addThree_y
    fsd   fa1, (t0)
    la    t0, PARAM_addThree_z
    fsd   fa2, (t0)
    la    t0, PARAM_addThree_x  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la    t0, PARAM_addThree_y  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    fadd.d fa0,fa0,ft0
    la    t0, PARAM_addThree_z  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    fadd.d fa0,fa0,ft0
    la t0,IDXresult
    fsd fa0,(t0)
    la t0,IDXresult
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_rectangleArea:
    # Function rectangleArea with 2 parameters
    la    t0, PARAM_rectangleArea_width
    fsd   fa0, (t0)
    la    t0, PARAM_rectangleArea_height
    fsd   fa1, (t0)
    la    t0, PARAM_rectangleArea_width  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la    t0, PARAM_rectangleArea_height  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    fmul.d fa0,fa0,ft0
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
FUNC_maxFour:
    # Function maxFour with 4 parameters
    la    t0, PARAM_maxFour_a
    fsd   fa0, (t0)
    la    t0, PARAM_maxFour_b
    fsd   fa1, (t0)
    la    t0, PARAM_maxFour_c
    fsd   fa2, (t0)
    la    t0, PARAM_maxFour_d
    fsd   fa3, (t0)
    la    t0, PARAM_maxFour_a  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXmax1
    fsd fa0,(t0)
    la    t0, PARAM_maxFour_b  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    la t0,IDXmax1
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_0
    la    t0, PARAM_maxFour_b  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXmax1
    fsd fa0,(t0)
    j END_IF_1
ELSEIF_0:
END_IF_1:
    la    t0, PARAM_maxFour_c  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    la t0,IDXmax1
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_2
    la    t0, PARAM_maxFour_c  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXmax1
    fsd fa0,(t0)
    j END_IF_3
ELSEIF_2:
END_IF_3:
    la    t0, PARAM_maxFour_d  # Load parameter address
    fld   ft0, (t0)  # Load parameter value
    la t0,IDXmax1
    fld ft1,(t0)
    # Compare ft0 :>) ft1 (jump if false)
    flt.d t0, ft1, ft0
    beqz t0, ELSEIF_4
    la    t0, PARAM_maxFour_d  # Load parameter address
    fld   fa0, (t0)  # Load parameter value
    la t0,IDXmax1
    fsd fa0,(t0)
    j END_IF_5
ELSEIF_4:
END_IF_5:
    la t0,IDXmax1
    fld fa0,(t0)
    # Return from function
    ret
    # Default return (0.0)
    li    t0, 0
    fcvt.d.w fa0, t0
    ret
