# 📸 CameraX App con Galería

Este proyecto es una aplicación Android que permite capturar fotografías utilizando CameraX, alternar entre cámara frontal y trasera, y visualizar las imágenes guardadas en una galería dentro de la misma app.

---

## 🚀 Características

- Vista previa en tiempo real usando CameraX.
- Captura de imágenes y guardado en almacenamiento interno de la app.
- Cambio de cámara entre frontal y trasera.
- Galería integrada con `ViewPager2` para visualizar las fotos capturadas.
- Uso de `ViewBinding` para una manipulación segura de vistas.
- Permisos dinámicos para acceder a la cámara.

---

## 📱 Tecnologías usadas

- **Kotlin**
- **Android Studio**
- **CameraX**
- **ViewPager2**
- **RecyclerView**
- **ViewBinding**
- **Glide** (para mostrar imágenes)

---

## 🛠️ Instalación y ejecución

1. Clona este repositorio:

```bash
git clone https://github.com/frank-froz/ProgMov/tree/main/Lab13
```

2. Abre el proyecto con Android Studio.

3. Conecta un dispositivo físico o emulador con cámara.

4. Ejecuta la app.

## 🔐 Permisos
La app solicita el permiso de cámara en tiempo de ejecución:

```
<uses-permission android:name="android.permission.CAMERA" />
<uses-feature android:name="android.hardware.camera.any" />
```

## 🎯 Estructura del proyecto

```
📁 app/
 └── java/com/huaytalla/franklin/lab13/
     ├── MainActivity.kt
     ├── GalleryActivity.kt
     ├── GalleryAdapter.kt
 └── res/layout/
     ├── activity_main.xml
     ├── activity_gallery.xml
     └── list_item_img.xml
```

## 📷 Captura

Pulsa "Take a photo" para tomar una imagen.

Usa "Switch" para cambiar entre cámaras.

Pulsa "Gallery" para ver todas las imágenes tomadas.

## ✅ Estado del proyecto

✅ Finalizado

🔧 Se pueden agregar mejoras como compartir imágenes o eliminarlas desde la galería.

## 👨‍💻 Autor
Franklin Huaytalla Rodriguez


## 📄 Licencia
Este proyecto es de uso académico. Puedes modificarlo y adaptarlo libremente con fines educativos.

yaml
Copiar
Editar
