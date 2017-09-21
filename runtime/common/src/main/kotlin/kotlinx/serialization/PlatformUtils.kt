package kotlinx.serialization

import kotlin.reflect.KClass

expect fun <T: Any> KClass<T>.serializer(): KSerializer<T>

expect fun String.toUtf8Bytes(): ByteArray
expect fun stringFromUtf8Bytes(bytes: ByteArray): String

expect fun <E: Enum<E>> enumFromName(enumClass: KClass<E>, value: String): E
expect fun <E: Enum<E>> enumFromOrdinal(enumClass: KClass<E>, ordinal: Int): E

expect fun <E: Enum<E>> KClass<E>.enumClassName(): String

expect fun <E: Any> ArrayList<E?>.toNativeArray(eClass: KClass<E>): Array<E?>