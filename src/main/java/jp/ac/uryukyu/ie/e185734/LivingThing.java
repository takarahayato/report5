package jp.ac.uryukyu.ie.e185734;



/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by e185734 on 2016/11/13.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    public boolean isDead(){
        return  dead;
    }
    /**
     *hitpointをgetする
     * @return hitPoint
     */
    public int getHitPoint(){

        return hitPoint;
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    public void setDead(boolean boole){
        this.dead = boole;
    }

    public String getName(){
        return name;
    }

    /**
     * ランダムに攻撃を与える
     * @param opponent
     */
    public void attack(LivingThing opponent) {
        if (!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }
}