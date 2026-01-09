package Eleventh;

public enum ImageFormat {
    // Форматы без потери качества
    BMP("bmp", false),
    PNG("png", false),
    TIFF("tiff", false),

    // Форматы с потерей качества
    JPEG("jpg", true),
    JPG("jpg", true),
    WEBP("webp", true),
    GIF("gif", true);

    private final String extension;
    private final boolean lossy;

    // Приватный конструктор
    ImageFormat(String extension, boolean lossy) {
        this.extension = extension;
        this.lossy = lossy;
    }

    /**
     * Получение расширения файла
     * @return строковое расширение файла
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Проверка, является ли формат форматом с потерей качества
     * @return true - с потерей качества, false - без потери
     */
    public boolean isLossy() {
        return lossy;
    }

    /**
     * Получение полного имени формата
     * @return полное название формата
     */
    @Override
    public String toString() {
        return name() + " (." + extension + ") - " +
                (lossy ? "с потерей качества" : "без потери качества");
    }

    public static void main(String[] args) {
        // Получение информации о форматах
        ImageFormat png = ImageFormat.GIF;
        System.out.println("Формат: " + png.name());
        System.out.println("Расширение: " + png.getExtension());
        System.out.println("С потерей качества? " + png.isLossy());

        // Использование всех значений enum
        System.out.println("\nВсе форматы:");
        for (ImageFormat format : ImageFormat.values()) {
            System.out.println(format);
        }
    }
}