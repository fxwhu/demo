package com.bmss.test.thread.volatileTestNew;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        List<PossibleReordering> possibleReorderings = Lists.newArrayList();
        for (int j = 0; j < 100000; j++) {
            PossibleReordering possibleReordering = new PossibleReordering();
            possibleReorderings.add(possibleReordering);
        }

        for (PossibleReordering possibleReordering:possibleReorderings) {
            possibleReordering.test();
        }

    }

}
