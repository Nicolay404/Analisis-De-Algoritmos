# 📄 README

## ⚡ IMPORTANTE ⚡

> **¡Atención!**  
> En el ejercicio propuesto en clases, al implementarlo en Java, **el resultado no era el esperado**.  
> Esto se debe a que en programación **los arreglos comienzan en índice 0**, mientras que en las **pruebas de escritorio realizadas en clase** se inicializó **empezando en 1**.  
>  
> ❗ Esta diferencia **afecta la posición de `q`** (el punto de partición del arreglo) y, en consecuencia, **modifica el resultado final** del algoritmo.

---

## 📂 Estructura de Carpetas

- **Tarea - Ejercicios Java**  
  - Contiene el **código original** junto con la **captura del algoritmo** y su **resultado obtenido en Java**.

- **Tarea - Ejercicios Java / Código Adaptado - Clases**  
  - Aquí se encuentra la versión **adaptada**:  
    - Se **modificó la fórmula** de cálculo de `q` (`q = (longitud-1)/2 - 1`)  
    - **Objetivo**: que el comportamiento del código coincida **exactamente** con el método visto en clase (donde los índices empezaban en 1).

---

## 🧠 Nota técnica adicional

> Al adaptar la fórmula de `q`, compensamos la diferencia de indexación entre **programación real** (base 0) y **pruebas humanas** (base 1).  
>  
> ✅ De esta manera, el resultado del `merge` es **idéntico** al que se esperaba en la actividad de clase, asegurando coherencia en el aprendizaje.

---

# 🚀 Conclusión

Cuando se trabaja con algoritmos en programación, **es fundamental tener en cuenta la base de los índices**:
- **En programación:** índice 0 (base cero)
- **En pruebas de escritorio humanas:** usualmente índice 1 (base uno)

⚡ **¡Pequeñas diferencias como estas pueden cambiar todo el comportamiento del algoritmo!**
