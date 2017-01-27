/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import javax.ejb.Remote;

/**
 *
 * @author Burak
 */
@Remote
public interface IRadar {
    
    public double[][] position();
    public double[] getEdge(int x, int y);
	

}
