package com.ailgorithm.stackqueue1;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.ailgorithm.stackqueue1
 * @Description:
 * @date 2019/5/26 22:46
 * @Company:
 */
public class PetEnterQueue {

    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public String getEnterPetType() {
        return this.pet.getPetType();
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
