/*
package com.runle.fooddoor.data.api

import com.runle.fooddoor.R


*/
/**
 * Created by elha on 05.10.2021.
 *//*

enum class ErrorType(private var code: Int, private var system: Boolean, private var message: Int) {
    */
/*OK(0, true, 0),*//*


   */
/* *//*
*/
/**
     * Special error type for empty response
     *//*
*/
/*
    EMPTY_RESPONSE(Int.MAX_VALUE - 1, true, R.string.network_error),

    *//*
*/
/**
     * No internet connection
     *//*
*/
/*
    NO_INTERNET(Int.MAX_VALUE - 2, true, R.string.network_no_internet_connection),

    *//*
*/
/**
     * Exception for an unexpected, non-2xx HTTP response
     *//*
*/
/*
    NON_2XX_HTTP(Int.MAX_VALUE - 3, true, R.string.network_no_endpoint),

    *//*
*/
/**
     * Network error
     *//*
*/
/*
    NETWORK_ERROR(Int.MAX_VALUE - 4, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Missed required parameter or invalid value
     *//*
*/
/*
    INVALID_REQUEST(1, true, R.string.network_no_endpoint),

    *//*
*/
/**
     * Session expired. Authorization required
     *//*
*/
/*
    SESSION_EXPIRED(2, true, R.string.network_no_endpoint),

    *//*
*/
/**
     * Unsupported API version
     *//*
*/
/*
    API_WRONG_VERSION(3, true, R.string.network_no_endpoint),

    *//*
*/
/**
     * Invalid API key
     *//*
*/
/*
    API_INVALID_KEY(4, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * License acceptance is required
     *//*
*/
/*
    LICENSE_EXPIRED(5, true, R.string.network_no_endpoint),

    *//*
*/
/**
     * Access denied
     *//*
*/
/*
    ACCESS_DENIED(6, true, R.string.network_no_endpoint),

    *//*
*/
/**
     * Access denied
     *//*
*/
/*
    OBJECT_NOT_FOUND(7, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * User is blocked. Error message can contain explanation
     *//*
*/
/*
    USER_BLOCKED(21, true, R.string.network_no_endpoint),

    *//*
*/
/**
     * OTP code was expired. Used as second authorization factor when registering
     *//*
*/
/*
    OTP_EXPIRED(22, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * OTP code not registered
     *//*
*/
/*
    OTP_NOT_REGISTERED(23, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Invalid OTP code
     *//*
*/
/*
    OTP_INVALID(24, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Неверный/неизвестный логин. Используется при регистрации
     *//*
*/
/*
    LOGIN_INVALID(25, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Выбран слишком большой интервал для выписки
     *//*
*/
/*
    RANGE_TOO_LARGE(26, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Счет не может быть закрыт, ненулевой баланс
     *//*
*/
/*
    UNABLE_TO_CLOSE_ACCOUNT(27, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Заблокированая банком карта не может быть разблокирована пользователем
     *//*
*/
/*
    UNABLE_TO_UNBLOCK_CARD(28, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Разбиение задолженности по кредиту недоступно
     *//*
*/
/*
    UNABLE_TO_SPLIT_CREDIT(29, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Данные не изменились
     *//*
*/
/*
    NOT_MODIFIED(30, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * Неизвестная/невалидная карта
     *//*
*/
/*
    CARD_INVALID(31, false, R.string.network_no_endpoint),

    *//*
*/
/**
     * 3ds /activate error call 196
     *//*
*/
/*
    ACTIVATION_3DS_CALL_196(458, false, 0),

    *//*
*/
/**
     * When device has been blocked
     *//*
*/
/*
    DEVICE_BLOCKED(103, false, 0),

    UNKNOWN(Integer.MAX_VALUE, false, R.string.network_error),

    *//*
*/
/**
     * No internet connection
     *//*
*/
/*
    NO_INTERNET_DATA(44, true, R.string.network_no_data);

    *//*
*/
/**
     * Is error code has app-wide effect
     *//*

    fun isSystem(): Boolean {
        return system
    }

    fun isServiceError(): Boolean {
        return code > 100
    }

    */
/**
     * Default message to show in case of error
     *//*

    fun getDefaultErrorMessage(): Int {
        return message
    }

    */
/**
     * Status code
     *//*

    fun getCode(): Int {
        return code
    }

    companion object {
        fun getType(value: Int): ErrorType {
            val values: Array<ErrorType> = values()
            for (errorType in values) {
                if (errorType.getCode() == value) {
                    return errorType
                }
            }
            return UNKNOWN
        }
    }
}
*/
