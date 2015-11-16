/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */

package org.mule.module.documentum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.apache.cxf.attachment.ByteDataSource;

import com.emc.documentum.fs.datamodel.core.DataObject;
import com.emc.documentum.fs.datamodel.core.ObjectIdentity;
import com.emc.documentum.fs.datamodel.core.ObjectIdentitySet;
import com.emc.documentum.fs.datamodel.core.OperationOptions;
import com.emc.documentum.fs.datamodel.core.content.BinaryContent;
import com.emc.documentum.fs.datamodel.core.content.ContentTransferMode;
import com.emc.documentum.fs.datamodel.core.content.DataHandlerContent;
import com.emc.documentum.fs.datamodel.core.context.RepositoryIdentity;
import com.emc.documentum.fs.datamodel.core.context.ServiceContext;
import com.emc.documentum.fs.datamodel.core.profiles.Profile;
import com.emc.documentum.fs.datamodel.core.query.PassthroughQuery;

public class Utils {

    public static String getRepositoryName(ServiceContext serviceContext) {
        return ((RepositoryIdentity) (serviceContext.getIdentities().get(0))).getRepositoryName();
    }

    public static String getUserName(ServiceContext serviceContext) {
        return ((RepositoryIdentity) (serviceContext.getIdentities().get(0))).getUserName();
    }

    public static String getPassword(ServiceContext serviceContext) {
        return ((RepositoryIdentity) (serviceContext.getIdentities().get(0))).getPassword();
    }

    public static void addContent(DataObject dataObject, ContentTransferMode transferMode, byte[] byteArray) {
        if (transferMode == ContentTransferMode.MTOM) {
            dataObject.getContents().add(getDataHandlerContent(byteArray));
        } else if (transferMode == ContentTransferMode.BASE_64) {
            dataObject.getContents().add(getBinaryContent(byteArray));
        }
    }

    public static DataHandlerContent getDataHandlerContent(byte[] byteArray) {
        DataSource byteDataSource = new ByteDataSource(byteArray);
        DataHandler dataHandler = new DataHandler(byteDataSource);
        DataHandlerContent dataHandlerContent = new DataHandlerContent();
        dataHandlerContent.setValue(dataHandler);
        return dataHandlerContent;
    }

    public static BinaryContent getBinaryContent(byte[] byteArray) {
        BinaryContent binaryContent = new BinaryContent();
        binaryContent.setValue(byteArray);
        return binaryContent;
    }

    public static byte[] fileToByteArray(File file) throws IOException {
        byte[] byteArray = new byte[(int) file.length()];
        InputStream fis = new FileInputStream(file);
        fis.read(byteArray);
        fis.close();
        return byteArray;
    }

    public static ObjectIdentitySet createObjectIdentitySet(ObjectIdentity objectIdentity) {
        ObjectIdentitySet objIdSet = new ObjectIdentitySet();
        objIdSet.getIdentities().add(objectIdentity);
        return objIdSet;
    }

    public static OperationOptions createOperationOptions(List<Profile> profiles) {
        OperationOptions operationOptions = new OperationOptions();
        for (Profile profile : profiles) {
            operationOptions.getProfiles().add(profile);
        }
        return operationOptions;
    }

    public static OperationOptions createOperationOptions(Profile profile) {
        OperationOptions operationOptions = new OperationOptions();
        operationOptions.getProfiles().add(profile);
        return operationOptions;
    }

    public static PassthroughQuery createQuery(String dqlStatement, ServiceContext serviceContext) {
        PassthroughQuery query = new PassthroughQuery();
        query.setQueryString(dqlStatement);
        query.getRepositories().add(getRepositoryName(serviceContext));
        return query;
    }

}