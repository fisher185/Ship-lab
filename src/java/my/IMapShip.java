package my;


import javax.ejb.Remote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Burak
 */
@Remote
interface IMapShip {
    public void init();
    public double[] position();

}
