package com.feywild.feywild.particles;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LeafParticle extends SpriteTexturedParticle {
    
    private float move = 0;
    private final double initX;
    private final double initZ;
    
    public LeafParticle(ClientWorld world, double x, double y, double z) {
        super(world, x, y, z);
        this.setSize(0.5f,0.5f);
        this.alpha = 0;
        this.lifetime = (int)(10 / (Math.random() * 0.8D)) + 20;
        this.initX = x;
        this.initZ = z;
    }

    @Nonnull
    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        super.tick();
        this.setPos(this.initX + Math.sin(this.move) * 2, this.y -0.04, this.initZ + Math.cos(this.move) * 2);
        this.move += 0.1;
        if(this.lifetime == 0){
            this.remove();
        }
        this.lifetime--;
        if(this.move > 0.3)
            this.alpha = 1;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>{

        private final IAnimatedSprite sprite;
        public Factory(IAnimatedSprite sprite){
            this.sprite = sprite;
        }

        @Nullable
        @Override
        public Particle createParticle(@Nonnull BasicParticleType type, @Nonnull ClientWorld world, double p_199234_3_, double p_199234_5_, double p_199234_7_, double p_199234_9_, double p_199234_11_, double p_199234_13_) {
            LeafParticle particle = new LeafParticle(world,p_199234_3_,p_199234_5_,p_199234_7_);
            particle.setColor(1,1,1);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}


