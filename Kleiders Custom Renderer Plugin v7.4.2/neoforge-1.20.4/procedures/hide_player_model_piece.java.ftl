if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
	com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), ${generator.map(field$piece, "playerModelPieces")});
}