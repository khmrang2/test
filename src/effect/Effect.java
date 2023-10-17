package effect;

import engine.Cooldown;
import engine.Core;
import engine.DrawManager.SpriteType;

public class Effect {

    /**
     * dummy item 1 effectCooldown
     */
    protected Cooldown tripleshotEffectCooldown;
    /**
     * dummy item 2 effectCooldown
     * 만드는 버프에 따라 이름을 달리 할 것.
     */
    protected Cooldown Buff2EffectCooldown;
    protected Cooldown attackSpeedEffectCooldown;
    protected Cooldown DebuffEffectCooldown;
    /** 스턴 아이템 */
    protected Cooldown debuffSturnEffect;



    /**
     * Initialize effect cool time
     */
    public Effect() {
        tripleshotEffectCooldown = Core.getCooldown(5000);
        attackSpeedEffectCooldown = Core.getCooldown(5000);
        DebuffEffectCooldown = Core.getCooldown(5000);
        debuffSturnEffect = Core.getCooldown(2000);
    }
    /**
     * Initialize effect cool time according to item Sprite
     *
     * @param s
     *          When an item collision event occurs,
     *          a sprite type of the item is received.
     */
    public void CooldownReset(SpriteType s) {
        double prob = Math.random();
        switch (s) {
            case Buff_Item:
                if(prob < 0.5){
                    tripleshotEffectCooldown.reset();
                }else{
                    attackSpeedEffectCooldown.reset();
                }
                break;
            case Debuff_Item:
                if(prob < 0.5){
                    DebuffEffectCooldown.reset();
                }else{
                    debuffSturnEffect.reset();
                }
                break;
            default:
                break;
        }
    }
}
