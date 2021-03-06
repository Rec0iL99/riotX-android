/*
 * Copyright 2018 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.matrix.android.internal.crypto.store.db.model

import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey

internal fun DeviceInfoEntity.Companion.createPrimaryKey(userId: String, deviceId: String) = "$userId|$deviceId"

// deviceInfoData contains serialized data
internal open class DeviceInfoEntity(@PrimaryKey var primaryKey: String = "",
                                     var deviceId: String? = null,
                                     var identityKey: String? = null,
                                     // var deviceInfoData: String? = null,
                                     var userId: String? = null,
                                     var isBlocked: Boolean? = null,
                                     var algorithmListJson: String? = null,
                                     var keysMapJson: String? = null,
                                     var signatureMapJson: String? = null,
                                     var unsignedMapJson: String? = null,
                                     var trustLevelEntity: TrustLevelEntity? = null,
                                     /**
                                      * We use that to make distinction between old devices (there before mine)
                                      * and new ones. Used for example to detect new unverified login
                                      */
                                     var firstTimeSeenLocalTs: Long? = null
) : RealmObject() {

//    // Deserialize data
//    fun getDeviceInfo(): MXDeviceInfo? {
//        return deserializeFromRealm(deviceInfoData)
//    }
//
//    // Serialize data
//    fun putDeviceInfo(deviceInfo: MXDeviceInfo?) {
//        deviceInfoData = serializeForRealm(deviceInfo)
//    }

    @LinkingObjects("devices")
    val users: RealmResults<UserEntity>? = null

    companion object
}
