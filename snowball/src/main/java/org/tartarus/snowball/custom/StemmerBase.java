package org.tartarus.snowball.custom;

import com.trimc.blogger.commons.exception.BusinessException;

public class StemmerBase {

	public static final String	CLASS_NAME	= "org.tartarus.snowball.EnglishStemmer4Use";

	private SnowballStemmerBase	stemmer;

	protected SnowballStemmerBase getStemmer() throws BusinessException {
		if (null == stemmer) instantiate();
		return stemmer;
	}

	protected void instantiate() throws BusinessException {
		try {

			Class<?> stemClass = Class.forName(CLASS_NAME);
			setStemmer((SnowballStemmerBase) stemClass.newInstance());

		} catch (ClassNotFoundException e) {
			throw new BusinessException(e, String.format("Class not found (class = %s)", CLASS_NAME));
		} catch (InstantiationException e) {
			throw new BusinessException(e, String.format("Unable to instantiate English Stemmer (class = %s)", CLASS_NAME));
		} catch (IllegalAccessException e) {
			throw new BusinessException(e);
		}
	}

	protected void setStemmer(SnowballStemmerBase stemmer) {
		this.stemmer = stemmer;
	}
}
