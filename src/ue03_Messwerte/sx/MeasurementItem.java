/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ue03_Messwerte.sx;

import java.util.Date;


/**
 *
 * @author steiner
 */
public class MeasurementItem
{
  private final String socket;
  private final long timestampMillis;
  private final double value;


  public MeasurementItem (String socket, double value)
  {
    this.socket = socket;
    this.timestampMillis = System.currentTimeMillis();
    this.value = value;
  }


  public String getSocket ()
  {
    return socket;
  }


  public long getTimestampMillis ()
  {
    return timestampMillis;
  }

  public String getTimestampAsString ()
  {
    Date date = new Date();
    date.setTime(timestampMillis);
    return String.format("%1$tL/%1$tT", date);
  }

  public double getValue ()
  {
    return value;
  }
  
  
  
}