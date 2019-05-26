package com.ailgorithm.stackqueue1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.ailgorithm.stackqueue1
 * @Description:
 * @date 2019/5/26 22:49
 * @Company:
 */
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
    }

    public void add(Pet pet) {
        if ("dog".equals(pet.getPetType())) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if ("cat".equals(pet.getPetType())) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("error not cat or dog");
        }
    }

    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {//取队头不移除
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();//队头移除
            }
        } else if (!this.dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("error queue is empty");
        }
    }

    public Dog pollDog() {
        if (!isDogQueueEmpty()) {
            return (Dog) dogQ.poll().getPet();
        } else {
            return null;
        }
    }

    public Cat pollCat() {
        if (!isCatQueueEmpty()) {
            return (Cat) catQ.poll().getPet();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return dogQ.isEmpty() && catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

}

