/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import org.jacop.constraints.XplusYlteqZ;
import org.jacop.constraints.Eq;
import org.jacop.constraints.Alldifferent;
import org.jacop.constraints.Diff2;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.core.Var;
import org.jacop.search.DepthFirstSearch;
import org.jacop.search.IndomainMin;
import org.jacop.search.Search;
import org.jacop.search.SelectChoicePoint;
import org.jacop.search.SimpleSelect;
import org.jacop.search.SmallestDomain;

/**
 *
 * @author PF
 */
public class CLPTask {
    protected Store store;
    protected Search search;
    protected IntVar[] vars;
    
    private IntVar t1;
    private IntVar t2;
    private IntVar t3;
    private IntVar t4;
    private IntVar d1;
    private IntVar d2;
    private IntVar d3;
    private IntVar d4;
    private IntVar proc1;
    private IntVar proc2;
    private IntVar proc3;
    private IntVar proc4;
    
    private int numItems;
    
    
    public CLPTask()
    {
        store = new Store();
        search = new DepthFirstSearch();
        int Inf = 10000;
        
        t1 = new IntVar(store, 0, Inf);
        t2 = new IntVar(store, 0, Inf);
        t3 = new IntVar(store, 0, Inf);
        t4 = new IntVar(store, 0, Inf);
        d1 = new IntVar(store, 5, 5);
        d2 = new IntVar(store, 4, 4);
        d3 = new IntVar(store, 6, 6);
        d4 = new IntVar(store, 3, 3);
        proc1 = new IntVar(store, 1, 2);
        proc2 = new IntVar(store, 1, 2);
        proc3 = new IntVar(store, 1, 2);
        proc4 = new IntVar(store, 1, 2);
    }
    
    public void model()
    {    
        XplusYlteqZ ctr = new XplusYlteqZ(t1, d1, t2);
        ctr = new XplusYlteqZ(t1, d1, t3);
        ctr = new XplusYlteqZ(t2, d2, t4);
//        Diff2 ctrDiff = new Diff2(store,
//                [[t1,proc1,d1,1], [t2,proc2,d2,1], [t3,proc3,d3,1],
//        [t4,proc4,d4,1]]);
        //store.impose(new Alldifferent(vars));?
    }
    
    public void search()
    {
//        SelectChoicePoint select = new SimpleSelect(vars, new SmallestDomain(), new IndomainMin());
//        search.labeling(store, select);
    }
    
    public String returnStoreString() {
        return store.toString() + "\nPóki co, to tyle :)";
    }
    
    
}
