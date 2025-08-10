// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelelite_swordsman extends EntityModel<Entity> {
	private final ModelRenderer EliteKnight;
	private final ModelRenderer leg_l;
	private final ModelRenderer cube_r1;
	private final ModelRenderer leg_r;
	private final ModelRenderer cube_r2;
	private final ModelRenderer body;
	private final ModelRenderer cube_r3;
	private final ModelRenderer arm_r;
	private final ModelRenderer arm_l;
	private final ModelRenderer head;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cape;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cape_lower;

	public Modelelite_swordsman() {
		textureWidth = 128;
		textureHeight = 128;

		EliteKnight = new ModelRenderer(this);
		EliteKnight.setRotationPoint(0.0F, 19.0F, -1.0F);

		leg_l = new ModelRenderer(this);
		leg_l.setRotationPoint(3.4375F, -8.3989F, 2.8702F);
		EliteKnight.addChild(leg_l);
		leg_l.setTextureOffset(67, 29).addBox(-3.0375F, 0.0489F, -3.7202F, 6.0F, 7.0F, 7.0F, 0.0F, false);
		leg_l.setTextureOffset(70, 71).addBox(-3.1875F, 1.6489F, -2.6202F, 5.0F, 11.0F, 5.0F, 0.0F, false);
		leg_l.setTextureOffset(75, 64).addBox(-2.6875F, 9.6489F, -6.1202F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0625F, 1.3989F, -3.8702F);
		leg_l.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(15, 63).addBox(-2.0F, -1.5F, -0.5F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		leg_r = new ModelRenderer(this);
		leg_r.setRotationPoint(-3.4375F, -8.3989F, 2.8702F);
		EliteKnight.addChild(leg_r);
		leg_r.setTextureOffset(65, 14).addBox(-3.6625F, 0.0489F, -3.7202F, 6.0F, 7.0F, 7.0F, 0.0F, false);
		leg_r.setTextureOffset(0, 63).addBox(-2.3125F, 1.6489F, -2.6202F, 5.0F, 11.0F, 5.0F, 0.0F, false);
		leg_r.setTextureOffset(50, 14).addBox(-1.8125F, 9.6489F, -6.1202F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.0625F, 1.3989F, -3.8702F);
		leg_r.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.3927F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(50, 20).addBox(-3.0F, -1.5F, -0.5F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0007F, -11.9286F, 3.065F);
		EliteKnight.addChild(body);
		body.setTextureOffset(36, 36).addBox(-6.2507F, 1.9286F, -4.065F, 12.0F, 4.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(36, 25).addBox(-5.2507F, -0.3214F, -5.065F, 10.0F, 2.0F, 9.0F, 0.0F, false);
		body.setTextureOffset(0, 25).addBox(-5.0007F, -12.3214F, -4.065F, 10.0F, 12.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(51, 76).addBox(3.9993F, -15.5714F, -4.315F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(69, 47).addBox(-4.5007F, -15.3214F, 3.935F, 9.0F, 3.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(71, 53).addBox(-5.5007F, -15.5714F, -4.315F, 1.0F, 3.0F, 8.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.4993F, -6.0714F, -8.565F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.setTextureOffset(0, 45).addBox(-0.7F, -6.0F, 0.0F, 7.0F, 11.0F, 7.0F, 0.0F, false);

		arm_r = new ModelRenderer(this);
		arm_r.setRotationPoint(-4.2507F, -11.5714F, -0.065F);
		body.addChild(arm_r);
		arm_r.setTextureOffset(21, 61).addBox(-7.5F, -2.25F, -3.75F, 7.0F, 7.0F, 7.0F, 0.0F, false);
		arm_r.setTextureOffset(33, 75).addBox(-6.5F, 4.75F, -2.75F, 4.0F, 11.0F, 5.0F, 0.0F, false);

		arm_l = new ModelRenderer(this);
		arm_l.setRotationPoint(5.7493F, -11.5714F, -0.065F);
		body.addChild(arm_l);
		arm_l.setTextureOffset(50, 0).addBox(-1.5F, -2.25F, -3.75F, 7.0F, 7.0F, 7.0F, 0.0F, false);
		arm_l.setTextureOffset(15, 75).addBox(0.5F, 4.75F, -2.75F, 4.0F, 11.0F, 5.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-0.0007F, -11.8214F, 0.7549F);
		body.addChild(head);
		head.setTextureOffset(48, 47).addBox(-3.5F, -7.5F, -2.8199F, 7.0F, 7.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(28, 37).addBox(0.0F, -14.5F, -2.8199F, 0.0F, 14.0F, 10.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -3.875F, -3.3199F);
		head.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
		cube_r4.setTextureOffset(78, 0).addBox(-2.75F, -3.375F, -2.1F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		cape = new ModelRenderer(this);
		cape.setRotationPoint(-0.0007F, -12.1689F, 4.3705F);
		body.addChild(cape);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 5.9725F, 2.0645F);
		cape.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.3927F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(24, 25).addBox(-12.9F, -4.625F, -4.6F, 8.0F, 0.0F, 4.0F, 0.0F, false);
		cube_r5.setTextureOffset(49, 61).addBox(-4.9F, -4.625F, -4.6F, 9.0F, 11.0F, 4.0F, 0.0F, false);
		cube_r5.setTextureOffset(24, 29).addBox(4.9F, -4.625F, -4.6F, 8.0F, 0.0F, 4.0F, 0.0F, false);

		cape_lower = new ModelRenderer(this);
		cape_lower.setRotationPoint(0.0F, 1.72F, 3.8241F);
		cape.addChild(cape_lower);
		cape_lower.setTextureOffset(0, 0).addBox(-12.9F, 0.0F, 0.0F, 25.0F, 25.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		EliteKnight.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.arm_r.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.arm_l.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}