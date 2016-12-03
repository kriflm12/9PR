/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ue03_Messwerte.sx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.AbstractTableModel;
import ue03_Messwerte.sx.MeasurementCollection;


/**
 *
 * @author steiner
 */
public class TableModel extends AbstractTableModel
{
  private static final String colNames [] = { "Time", "Socket", "Value" };
  private final MeasurementCollection mc;

  public TableModel (MeasurementCollection mc)
  {
    this.mc = mc;
    mc.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed (ActionEvent e)
      {
        fireTableDataChanged();
      }
    });
  }
  
  
  @Override
  public int getRowCount ()
  {
    return mc.size();
  }


  @Override
  public int getColumnCount ()
  {
    return colNames.length;
  }


  @Override
  public String getColumnName (int column)
  {
    return colNames[column];
  }

  
  

  @Override
  public Object getValueAt (int rowIndex, int columnIndex)
  {
    MeasurementItem item = mc.get(rowIndex);
    switch (columnIndex)
    {
      case 0: return item.getTimestampAsString();
      case 1: return item.getSocket();
      case 2: return String.format("%.3f", item.getValue());
      default: throw new IllegalArgumentException();
    }
  }
}