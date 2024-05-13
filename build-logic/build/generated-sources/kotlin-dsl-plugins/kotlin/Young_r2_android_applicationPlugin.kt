/**
 * Precompiled [young.r2.android.application.gradle.kts][Young_r2_android_application_gradle] script plugin.
 *
 * @see Young_r2_android_application_gradle
 */
public
class Young_r2_android_applicationPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Young_r2_android_application_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
