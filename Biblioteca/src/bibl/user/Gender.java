package bibl.user;
/**En lugar de usar Strings libres (donde cualquiera podría escribir "Masc" o "Hombre"),
 * limitamos las opciones a valores predefinidos
 * Esto garantiza que la base de datos sea consistente y fácil de filtrar.
 */
public enum Gender {
    MASCULINO, FEMENINO, OTRO
}
