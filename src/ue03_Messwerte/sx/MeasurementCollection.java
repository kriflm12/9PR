/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ue03_Messwerte.sx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 *
 * @author steiner
 */
public class MeasurementCollection
{
  private final ArrayList<MeasurementItem> list = new ArrayList<>();
  private final LinkedList<ActionListener> listeners = new LinkedList<>();
  
  public void addActionListener (ActionListener listener)
  {
    listeners.add(listener);
  }
  
  public void removeActionListener (ActionListener listener)
  {
    listeners.remove(listener);
  }
  
  public void add (MeasurementItem item)
  {
    list.add(item);
    if (listeners.isEmpty())
      return;
    ActionEvent ev = new ActionEvent(this, 0, null);
    for (ActionListener l : listeners)
      l.actionPerformed(ev);
  }
  
  public int size ()
  {
    return list.size();
  }
  
  public MeasurementItem get (int index)
  {
    return list.get(index);
  }
  
}