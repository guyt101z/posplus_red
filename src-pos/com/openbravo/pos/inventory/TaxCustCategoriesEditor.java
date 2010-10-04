//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2008 Openbravo, S.L.
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

package com.openbravo.pos.inventory;

import java.awt.Component;
import java.util.UUID;
import javax.swing.*;

import com.openbravo.format.Formats;
import com.openbravo.basic.BasicException;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.DirtyManager;
import com.openbravo.pos.forms.AppLocal;

public class TaxCustCategoriesEditor extends JPanel implements EditorRecord {
    
    private Object m_oId;
    
    /** Creates new form taxEditor */
    public TaxCustCategoriesEditor(DirtyManager dirty) {
        initComponents();

        m_jName.getDocument().addDocumentListener(dirty);
        
        writeValueEOF();
    }
    public void writeValueEOF() {
        m_oId = null;
        m_jName.setText(null);
        m_jName.setEnabled(false);
    }
    public void writeValueInsert() {
        m_oId = null;
        m_jName.setText(null);
        m_jName.setEnabled(true);
    }
    public void writeValueDelete(Object value) {

        Object[] taxcustcat = (Object[]) value;
        m_oId = taxcustcat[0];
        m_jName.setText(Formats.STRING.formatValue(taxcustcat[1]));
        m_jName.setEnabled(false);
    }    
    public void writeValueEdit(Object value) {

        Object[] taxcustcat = (Object[]) value;
        m_oId = taxcustcat[0];
        m_jName.setText(Formats.STRING.formatValue(taxcustcat[1]));
        m_jName.setEnabled(true);
    }

    public Object createValue() throws BasicException {
        
        Object[] taxcustcat = new Object[2];

        taxcustcat[0] = m_oId == null ? UUID.randomUUID().toString() : m_oId;
        taxcustcat[1] = m_jName.getText();

        return taxcustcat;
    }    
     
    public Component getComponent() {
        return this;
    }
    
    public void refresh() {
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        m_jName = new javax.swing.JTextField();

        setLayout(null);

        jLabel2.setText(AppLocal.getIntString("Label.Name")); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(20, 20, 80, 15);
        add(m_jName);
        m_jName.setBounds(100, 20, 200, 19);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField m_jName;
    // End of variables declaration//GEN-END:variables

}
