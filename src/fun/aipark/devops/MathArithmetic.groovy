package fun.aipark.devops

/**
 * @author LDC
 */
class MathArithmetic implements Serializable {

    Object script = null

    int add(int a, int b) {
        script.echo "Adding ${a} to ${b} = ${a + b}"
        return a + b
    }

}
