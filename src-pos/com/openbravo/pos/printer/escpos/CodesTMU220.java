//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2008 Openbravo, S.L.
//    http://sourceforge.net/projects/openbravopos
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package com.openbravo.pos.printer.escpos;

import java.awt.image.BufferedImage;

public class CodesTMU220 extends Codes {
    
    private static final byte[] INITSEQUENCE = {};

    public static final byte[] CHAR_SIZE_0 = {0x1B, 0x21, 0x01}; // This sets 7x9 font 
    public static final byte[] CHAR_SIZE_1 = {0x1B, 0x21, 0x11}; // This sets double hight 7x9 font 
    public static final byte[] CHAR_SIZE_2 = {0x1B, 0x21, 0x21}; // This sets 7x9 double width font 
    public static final byte[] CHAR_SIZE_3 = {0x1B, 0x21, 0x31}; // This sets 7x9 double width/hight font 
    
    public static final byte[] BOLD_SET = {0x1B, 0x45, 0x01};
    public static final byte[] BOLD_RESET = {0x1B, 0x45, 0x00};
    public static final byte[] UNDERLINE_SET = {0x1B, 0x2D, 0x01};
    public static final byte[] UNDERLINE_RESET = {0x1B, 0x2D, 0x00};

    private static final byte[] OPEN_DRAWER = {0x1B, 0x70, 0x00, 0x32, -0x06};    
    private static final byte[] PARTIAL_CUT_1 = {0x1B, 0x69};
    private static final byte[] IMAGE_HEADER = {0x1D, 0x76, 0x30, 0x03};
    private static final byte[] NEW_LINE = {0x0D, 0x0A}; // Print and carriage return    

    /** Creates a new instance of CodesTMU220 */
    public CodesTMU220() {
    }
     
    public byte[] getInitSequence() { return INITSEQUENCE; }
     
    public byte[] getSize0() { return CHAR_SIZE_0; }
    public byte[] getSize1() { return CHAR_SIZE_1; }
    public byte[] getSize2() { return CHAR_SIZE_2; }
    public byte[] getSize3() { return CHAR_SIZE_3; }

    public byte[] getBoldSet() { return BOLD_SET; }
    public byte[] getBoldReset() { return BOLD_RESET; }
    public byte[] getUnderlineSet() { return UNDERLINE_SET; }
    public byte[] getUnderlineReset() { return UNDERLINE_RESET; }
    
    public byte[] getOpenDrawer() { return OPEN_DRAWER; }    
    public byte[] getCutReceipt() { return PARTIAL_CUT_1; }   
    public byte[] getNewLine() { return NEW_LINE; } 
    public byte[] getImageHeader() { return IMAGE_HEADER; } // Not used
    
    @Override
    public byte[] transImage(BufferedImage oImage) {
        // Nothing to print
        return new byte[0];
    }
}
